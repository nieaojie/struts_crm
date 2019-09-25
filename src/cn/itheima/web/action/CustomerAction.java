package cn.itheima.web.action;

import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import cn.itheima.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    //接口无法实例化。不过实现接口的子类可以通过创建对象赋值给接口。
    private CustomerService cs = new CustomerServiceImpl();
    private Customer customer = new Customer();

    //客户列表
    public String list() throws Exception {
        //1.接收参数
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String cust_name = request.getParameter("cust_name");
        //2、创建离线查询对象
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        //3.判断参数拼装条件
        if (StringUtils.isNotBlank(cust_name)) {
            dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
        }
        //4.调用Service将离线对象传递
        List<Customer> customerList = cs.getAll(dc);
        //5.将返回到的list放入request域，转发到list.jsp显示
        request.setAttribute("list",customerList);
        return "list";
    }

    //添加客户
    public String add() throws Exception {
        cs.save(customer);
        return "toList";
    }

    @Override
    public Customer getModel() {
        return customer;
    }
}
