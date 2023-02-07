package com.kimmy.learn.web.entity.domains.db;

import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;
import com.kimmy.learn.web.entity.domains.generate.PolicyDetail;
import com.kimmy.learn.web.util.FileUtils;
import com.kimmy.learn.web.util.PathUtils;
import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TablePack extends Table {

    private String className;
    private String fullClassName;
    private String mapperPonintPath;
    private List<ColumnPack> columnList;
    private PolicyDetail policyDetail;

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public List<ColumnPack> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnPack> columnList) {
        this.columnList = columnList;
    }

    public PolicyDetail getPolicyDetail() {
        return policyDetail;
    }

    public void setPolicyDetail(PolicyDetail policyDetail) {
        this.policyDetail = policyDetail;
    }

    public String getMapperPonintPath() {
        return mapperPonintPath;
    }

    public void setMapperPonintPath(String mapperPonintPath) {
        this.mapperPonintPath = mapperPonintPath;
    }

    public TablePack initForTemplateCreate() {
        this.className = StringUtils.toClassName(tableName);
        columnList.forEach(column -> column.initForTemplateCreate());

        GeneratePolicyDetail MAPPERXML = policyDetail.getDetailList().stream().filter(detail -> "MAPPERXML".equals(detail.getImportRule())).findAny().orElse(null);
        if (null != MAPPERXML) {
            this.mapperPonintPath = PathUtils.toPointPath(MAPPERXML.getGenerateRelativePath());
        }

        GeneratePolicyDetail ENTITY = policyDetail.getDetailList().stream().filter(detail -> "ENTITY".equals(detail.getImportRule())).findAny().orElse(null);
        if (null != ENTITY) {
            this.mapperPonintPath = PathUtils.toPointPath(MAPPERXML.getGenerateRelativePath());
        }

        return this;
    }

    public String tableImports(GeneratePolicyDetail generatePolicyDetail) {

        String imports = "";

        // if("MAPPER".equals())

        if (!StringUtils.isEmpty(generatePolicyDetail.getImportRule())) {
            switch (generatePolicyDetail.getImportRule()) {
                case "ENTITY":
                    String columnImports = columnImports();
                    imports += columnImports;
                    break;
                case "MAPPER":
                    String mapperImport = mapperImport();
                    imports += mapperImport;
                    break;
                default:
                    ;
            }
        }

        return imports;
    }

    private String mapperImport() {

        // MAPPER 引入Entity

        GeneratePolicyDetail generatePolicyDetail = policyDetail.getDetailList().stream().filter(detail -> "ENTITY".equals(detail.getImportRule())).findAny().orElse(null);
        if (null == generatePolicyDetail)
            return "";
        String entityName = PathUtils.toPointPath(generatePolicyDetail.getGenerateRelativePath()) + FileUtils.POINT + className;
        String mapperImport = "import " + entityName + ";";
        return mapperImport;
    }

    public String columnImports() {

        List<String> importList = new ArrayList<>();

        String importStr = columnList.stream().map(column -> {
            String classType = column.getClassType();
            if (!importList.contains(classType) && !classType.startsWith("java.lang")) {
                importList.add(classType);
                return "import " + classType + ";\r\n";
            } else if (classType.startsWith("java.lang")) {
                column.setClassType(shortLangClassType(classType));
            }
            return "";
        }).collect(Collectors.joining());

        return importStr;
    }

    private String shortLangClassType(String classType) {
        if (classType.contains(FileUtils.POINT)) {
            return classType.substring(classType.lastIndexOf(FileUtils.POINT) + 1);
        }
        return classType;
    }
}

