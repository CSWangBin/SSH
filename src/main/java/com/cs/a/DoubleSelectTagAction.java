package com.cs.a;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import java.util.*;

/**
 * Created by 举 on 2016/12/14.
 */
public class DoubleSelectTagAction implements Action {
    private List<Provice> provices;// Provice对象的列表
    private Map<Provice, List<City>> cityMap;// 以Provice对象为key,Provice对应的City对象的列表作为value

    public DoubleSelectTagAction(){

        provices = new ArrayList<>();


        Provice provice1 = new Provice(1,"四川省");
        Provice provice2 = new Provice(2,"山东省");
        Provice provice3 = new Provice(3,"湖南省");
        Provice provice4 = new Provice(4,"广东省");

        provices.add(provice1);
        provices.add(provice2);
        provices.add(provice3);
        provices.add(provice4);


        List<City> cities1 = new ArrayList<City>();
        List<City> cities2 = new ArrayList<City>();
        List<City> cities3 = new ArrayList<City>();
        List<City> cities4 = new ArrayList<City>();

        cities1.add(new City(1,"成都市"));
        cities1.add(new City(2,"绵阳市"));

        cities2.add(new City(1,"济南市"));
        cities2.add(new City(2,"青岛市"));

        cities3.add(new City(1,"长沙市"));
        cities3.add(new City(2,"郴州市"));

        cities4.add(new City(1,"广州市"));
        cities4.add(new City(2,"深圳市"));


        cityMap = new HashMap<>();
        cityMap.put(provice1, cities1);
        cityMap.put(provice2, cities2);
        cityMap.put(provice3, cities3);
        cityMap.put(provice4, cities4);

    }
    public String execute() throws Exception {
        return SUCCESS;
    }

    public List<Provice> getProvices(){
        return provices;
    }

    @SuppressWarnings("unchecked")
    public List<City> getCities(){
        ValueStack stack = ServletActionContext.getValueStack(ServletActionContext.getRequest());
        Object provice = stack.findValue("top");//获取栈顶对象


        if(provice != null && provice instanceof Provice){

            List<City> lst = (List<City>)cityMap.get(provice);
            return lst;
        }
        return Collections.EMPTY_LIST;
    }
}
