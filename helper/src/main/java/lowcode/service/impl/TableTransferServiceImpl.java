package lowcode.service.impl;

import lowcode.mapper.TableCreateMapper;
import lowcode.service.TableTransferService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import util.PathUtil;
import wincommand.WinRunner;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @description: 表结构抽取
 * @author: liyq
 * @createtime: 2023-04-06 09:36:36
 */
public class TableTransferServiceImpl implements TableTransferService {

    @Override
    public void transferDbToFile(String schema, SqlSession sqlSession, String username, String password) throws Exception {

        TableCreateMapper createMapper = sqlSession.getMapper(TableCreateMapper.class);

        // String schema = createMapper.schema();

        File sqlPackage = new File("helper/src/main/java/lowcode/service/impl/tabletransfer/createsql");
        if (sqlPackage.list().length > 0) {
            Arrays.stream(sqlPackage.listFiles()).forEach(subFile -> subFile.delete());
        }

        String tableTransferSqlCommand = "mysqldump --compact --extended-insert=false -u" + username + " -p" + password + " " + schema + ">" + PathUtil.matchLinePath(sqlPackage.getAbsolutePath()) + "/" + schema + ".sql";

        WinRunner.runCmd(tableTransferSqlCommand);
    }

    @Override
    public void transferTableToDb(String schema, SqlSession sqlSession, String username, String password) throws IOException, InterruptedException {

        // 1、如果库存在，删除数据库
        // 2、创建数据库
        // 3、导入文件

        TableCreateMapper createMapper = sqlSession.getMapper(TableCreateMapper.class);
        String database = createMapper.searchDatabase(schema);
        if (!StringUtils.isEmpty(database)) {
            createMapper.dropDatabase(database);
        }
        createMapper.createDatabase(database);

        File sqlPackage = new File("helper/src/main/java/lowcode/service/impl/tabletransfer/createsql");
        File[] files = sqlPackage.listFiles();
        File scemaFile = Arrays.stream(files).filter(file -> file.isFile() && file.getName().equals(schema + ".sql")).findFirst().orElse(null);
        if (null == scemaFile) {
            System.err.println("导入文件不存在");
            return;
        }
        String command = "mysql -u" + username + " -p" + password + " " + schema + " <" + scemaFile.getAbsolutePath();
        WinRunner.runCmd(command);
    }
}