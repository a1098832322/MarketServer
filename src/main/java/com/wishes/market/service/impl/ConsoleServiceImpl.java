package com.wishes.market.service.impl;

import com.wishes.market.config.CommConfig;
import com.wishes.market.mapper.CommodityDoMapperExt;
import com.wishes.market.mapper.UserDoMapperExt;
import com.wishes.market.model.CommodityDo;
import com.wishes.market.model.UserDo;
import com.wishes.market.model.UserDoExample;
import com.wishes.market.service.ConsoleService;
import com.wishes.market.utils.IOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台配置接口实现类
 *
 * @author 郑龙
 * @date 2019/2/28
 **/
@Slf4j
@Service
public class ConsoleServiceImpl implements ConsoleService {
    @Autowired(required = false)
    private CommodityDoMapperExt commodityDoMapperExt;

    @Autowired(required = false)
    private UserDoMapperExt userDoMapperExt;

    /**
     * 图片文件保存路径
     */
    @Value("${image.save.path}")
    private String SAVE_PATH;

    /**
     * nginx映射出来的图片url
     */
    @Value("${image.save.url}")
    private String SAVE_URL;

    /**
     * 添加一条商品信息
     *
     * @param commodity 商品信息
     * @return true/false
     */
    @Override
    public boolean addCommodity(CommodityDo commodity) {
        try {
            //取读base64编码的图片
            //base64字符串(裁剪掉头注明)
            String file = commodity.getCommodityImg()
                    .substring(commodity.getCommodityImg().indexOf("base64") + 7);
            //将字符串转换为byte数组
            byte[] bytes = new BASE64Decoder().decodeBuffer(file.trim());
            //转化为输入流
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            //构造文件名(去空格，防止找不到)
            String fileName = commodity.getCommodityName()
                    .replaceAll(" ", "") + ".jpg";

            //存入文件
            IOUtil.saveImg(inputStream, SAVE_PATH, fileName);

            //补全model信息
            commodity.setIsDeleted(CommConfig.IS_DELETE.NO.getType());
            commodity.setCommoditySurplus(commodity.getCommodityTotal());
            //对文件名进行url编码，防止链接乱码
            fileName = URLEncoder.encode(fileName, "utf-8");
            commodity.setCommodityOtherImgUrls(SAVE_URL + fileName);
            commodityDoMapperExt.insertSelective(commodity);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("新增商品信息失败！");
        }

        return false;
    }

    /**
     * 列举出所有用户(管理员用)
     *
     * @return user List
     */
    @Override
    public List<UserDo> listUser() {
        try {
            UserDoExample example = new UserDoExample();
            UserDoExample.Criteria criteria = example.createCriteria();
            criteria.andIsDeletedEqualTo(CommConfig.IS_DELETE.NO.getType());
            List<UserDo> userList = userDoMapperExt.selectByExample(example);
            //对结果进行解析
            if (CollectionUtils.isEmpty(userList)) {
                return null;
            } else {
                return userList.stream().peek(userDo -> {
                    //保护用户信息，将敏感信息置空后传回前端
                    userDo.setPassword(null);
                    userDo.setCreateTime(null);
                    userDo.setIsDeleted(null);
                }).collect(Collectors.toList());
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("拉取用户列表失败", e);
        }

        return null;
    }


}
