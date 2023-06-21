package lowcode;

import lowcode.entity.table.Table;
import lowcode.service.BankDealService;
import lowcode.service.TableStruct;
import lowcode.service.impl.BankDealServiceImpl;
import lowcode.service.impl.TableStructImpl;
import mybatis.sqlutil.SqlSessionFactoryUtil;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 对接银行
 * @author: liyq
 * @createtime: 2023-06-21 14:06:03
 */
public class BankDeal {

    String baseUrl = "D:\\workspaces\\workspace_wanlian\\fuxi-plat-dubbo\\fuxi-modules\\xdt-loanplat\\src\\main\\java\\com\\haier\\vanlinks\\loanplat\\bank\\bankself";
    String bankName = "pa";

    public static void main(String[] args) throws Exception {

        BankDealService bankDealService = new BankDealServiceImpl();
        //
    }
}
