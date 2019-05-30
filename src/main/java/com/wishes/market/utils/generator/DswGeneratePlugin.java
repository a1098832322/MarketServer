package com.wishes.market.utils.generator;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.*;
import org.mybatis.generator.codegen.XmlConstants;
import org.mybatis.generator.config.PropertyRegistry;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * myabtis-generate自定义生成
 *
 * @author huangt
 * @create 2018-01-07 10:45
 **/
public class DswGeneratePlugin extends PluginAdapter {

    private static final String JAVAFILE_POTFIX = "Ext";
    private static String XMLFILE_POSTFIX = "Ext";
    private static String ANNOTATION_RESOURCE = "javax.annotation.Resource";
    private static String FULLY_QUALIFIED_PAGE = "com.wishes.market.utils.PageDto";
    private static String SQLMAP_COMMON_POTFIX = "and is_deleted = 'N'";


    public String toTest(){
        return "擦擦擦";
    }
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    // 生成XXExt.java
    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType()
                + JAVAFILE_POTFIX);
        Interface interfaze = new Interface(type);
        interfaze.setVisibility(JavaVisibility.PUBLIC);
        context.getCommentGenerator().addJavaFileComment(interfaze);

        FullyQualifiedJavaType baseInterfaze = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
        interfaze.addSuperInterface(baseInterfaze);

//        FullyQualifiedJavaType annotation = new FullyQualifiedJavaType(ANNOTATION_RESOURCE);
//        interfaze.addAnnotation("@Resource");
//        interfaze.addImportedType(annotation);

        CompilationUnit compilationUnits = interfaze;
        GeneratedJavaFile generatedJavaFile = new GeneratedJavaFile(compilationUnits,
                context.getJavaModelGeneratorConfiguration().getTargetProject(),
                context.getProperty(PropertyRegistry.CONTEXT_JAVA_FILE_ENCODING),
                context.getJavaFormatter());

        List<GeneratedJavaFile> generatedJavaFiles = new ArrayList<>();
        if (!isExistExtFile(generatedJavaFile.getTargetProject(), generatedJavaFile.getTargetPackage(),
                generatedJavaFile.getFileName())) {
            generatedJavaFiles.add(generatedJavaFile);
        }
        return generatedJavaFiles;
    }

    // 生成XXExt.xml
    @Override
    public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable) {

        String[] splitFile = introspectedTable.getMyBatis3XmlMapperFileName().split("\\.");
        String fileNameExt = null;
        if (splitFile[0] != null) {
            fileNameExt = splitFile[0] + XMLFILE_POSTFIX + ".xml";
        }

        if (isExistExtFile(context.getSqlMapGeneratorConfiguration().getTargetProject(),
                introspectedTable.getMyBatis3XmlMapperPackage(), fileNameExt)) {
            return super.contextGenerateAdditionalXmlFiles(introspectedTable);
        }

        Document document = new Document(XmlConstants.MYBATIS3_MAPPER_PUBLIC_ID,
                XmlConstants.MYBATIS3_MAPPER_SYSTEM_ID);

        XmlElement root = new XmlElement("mapper");
        document.setRootElement(root);
        String namespace = introspectedTable.getMyBatis3SqlMapNamespace() + XMLFILE_POSTFIX;
        root.addAttribute(new Attribute("namespace", namespace));

        GeneratedXmlFile gxf = new GeneratedXmlFile(document, fileNameExt,
                introspectedTable.getMyBatis3XmlMapperPackage(),
                context.getSqlMapGeneratorConfiguration().getTargetProject(), false,
                context.getXmlFormatter());

        List<GeneratedXmlFile> answer = new ArrayList<GeneratedXmlFile>(1);
        answer.add(gxf);

        return answer;
    }

    @Override
    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
                                                           IntrospectedTable introspectedTable) {
        Parameter parameter = new Parameter(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()),
                "record");
        method.getParameters().clear();
        method.addParameter(parameter);
        return super.clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable);
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addPageDto(topLevelClass, introspectedTable, "pageDto");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        XmlElement rootElement = document.getRootElement();
        updateDocumentNameSpace(introspectedTable, rootElement);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    // selectByExample
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {

        XmlElement orderbyElement = (XmlElement) element.getElements().remove(element.getElements().size() - 1);
        XmlElement isdeletedElement = new XmlElement("if");
        isdeletedElement.addAttribute(new Attribute("test", "oredCriteria.size != 0"));
        isdeletedElement.addElement(new TextElement(SQLMAP_COMMON_POTFIX));
        element.addElement(isdeletedElement);
        isdeletedElement = new XmlElement("if");
        isdeletedElement.addAttribute(new Attribute("test", "oredCriteria.size == 0"));
        isdeletedElement.addElement(new TextElement("where is_deleted = 'N'"));
        element.addElement(isdeletedElement);

        element.addElement(orderbyElement);

        XmlElement limitPageElement = new XmlElement("if");
        limitPageElement.addAttribute(new Attribute("test", "pageDto != null"));
        limitPageElement.addElement(new TextElement("limit ${pageDto.offset},${pageDto.pageSize}"));
        element.addElement(limitPageElement);
        return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test", "oredCriteria.size != 0"));
        isNotNullElement.addElement(new TextElement(SQLMAP_COMMON_POTFIX));
        element.addElement(isNotNullElement);
        isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test", "oredCriteria.size == 0"));
        isNotNullElement.addElement(new TextElement("where is_deleted = 'N'"));
        element.addElement(isNotNullElement);
        return super.sqlMapCountByExampleElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        TextElement text = new TextElement(SQLMAP_COMMON_POTFIX);
        element.addElement(text);
        return super.sqlMapSelectByPrimaryKeyElementGenerated(element, introspectedTable);
    }

    // updateByPrimaryKeySelective
    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {
        TextElement text = new TextElement(SQLMAP_COMMON_POTFIX);
        element.addElement(text);
        return super.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,
                                                                        IntrospectedTable introspectedTable) {
        TextElement text = new TextElement(SQLMAP_COMMON_POTFIX);
        element.addElement(text);
        return super.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        selectKey(element, introspectedTable);
        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        selectKey(element, introspectedTable);
        return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
    }

    /**
     * 删除方法重写，所有删除都是软删除
     *
     * @param element
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        element.setName("update");
        int replaceInd = -1;
        for (int i = 0; i < element.getAttributes().size(); i++) {
            Attribute attr = element.getAttributes().get(i);
            if (attr.getName().equals("parameterType")) {
                replaceInd = i;
                break;
            }
        }
        if (replaceInd >= 0) {
            element.getAttributes().remove(replaceInd);
            element.getAttributes().add(replaceInd,
                    new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        }

        List<Element> removeElement = new ArrayList<Element>();
        for (int i = 5; i < element.getElements().size(); i++) {
            removeElement.add(element.getElements().get(i));

        }
        element.getElements().removeAll(removeElement);

        element.getElements().add(new TextElement("update "
                + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()
                + " set is_deleted = 'Y' where ID = #{id,jdbcType=NUMERIC}"));
        return super.sqlMapDeleteByPrimaryKeyElementGenerated(element, introspectedTable);
    }

    /**
     * 获取插入主键
     *
     * @param element
     * @param introspectedTable
     */
    private void selectKey(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement selectKey = new XmlElement("selectKey");
        selectKey.addAttribute(new Attribute("keyProperty", "id"));
        selectKey.addAttribute(new Attribute("resultType", "long"));
        selectKey.addElement(new TextElement("select LAST_INSERT_ID()"));
        element.getElements().add(0, selectKey);
    }

    private void updateDocumentNameSpace(IntrospectedTable introspectedTable, XmlElement parentElement) {
        Attribute namespaceAttribute = null;
        for (Attribute attribute : parentElement.getAttributes()) {
            if (attribute.getName().equals("namespace")) {
                namespaceAttribute = attribute;
            }
        }
        parentElement.getAttributes().remove(namespaceAttribute);
        parentElement.getAttributes().add(new Attribute("namespace", introspectedTable.getMyBatis3JavaMapperType()
                + JAVAFILE_POTFIX));
    }

    /**
     * 在XXExample对象里添加Page对象属性
     */
    private void addPageDto(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType(FULLY_QUALIFIED_PAGE));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType(FULLY_QUALIFIED_PAGE));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType(FULLY_QUALIFIED_PAGE), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType(FULLY_QUALIFIED_PAGE));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    private boolean isExistExtFile(String targetProject, String targetPackage, String fileName) {
        File project = new File(targetProject);
        if (!project.isDirectory()) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(targetPackage, ".");
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            sb.append(File.separatorChar);
        }
        File directory = new File(project, sb.toString());
        if (!directory.isDirectory()) {
            boolean rc = directory.mkdirs();
            if (!rc) {
                return true;
            }
        }
        File testFile = new File(directory, fileName);
        if (testFile.exists()) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
