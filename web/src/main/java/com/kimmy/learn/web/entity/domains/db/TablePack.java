package com.kimmy.learn.web.entity.domains.db;

import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;
import com.kimmy.learn.web.entity.domains.generate.PolicyDetail;
import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TablePack extends Table {

    private String className;
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

    public TablePack initForTemplateCreate() {
        this.className = StringUtils.toClassName(tableName);
        columnList.forEach(column -> column.initForTemplateCreate());
        return this;
    }

    public String tableImports(GeneratePolicyDetail generatePolicyDetail) {

        String imports = "";

        String columnImports = columnImports();
        imports += columnImports;

        // if("MAPPER".equals())

        if (!StringUtils.isEmpty(generatePolicyDetail.getImportRule())) {
            switch (generatePolicyDetail.getImportRule()){
                case "MAPPER":
                    String mapperImport = mapperImport();
                    break;
                default:;
            }
        }

        return null;
    }

    private String mapperImport() {
        String mapperImport = "";



        return mapperImport;
    }

    public String columnImports() {

        List<String> importList = new ArrayList<>();

        String importStr = columnList.stream().map(column -> {
            String classType = column.getClassType();
            if (!importList.contains(classType) && !classType.startsWith("java.lang")) {
                importList.add(classType);
                return "import " + classType + ";\r\n";
            }
            return "";
        }).collect(Collectors.joining());

        return importStr;
    }
}

