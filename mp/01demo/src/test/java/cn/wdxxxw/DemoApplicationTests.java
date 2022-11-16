package cn.wdxxxw;

import cn.wdxxxw.entity.User;
import cn.wdxxxw.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询所有数据
    @Test
    void selectAll() {
        //System.out.println("--------selectAll method test------------");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    //插入
    @Test
    void insert() {
        User user = new User();
        user.setName("薛");
        user.setAge(32);
        user.setEmail("jj@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("insert" + insert);
    }

    //修改
    @Test
    void update() {
        User user = new User();
        user.setId(1537598328570941442L);
        user.setAge(120);
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

    //测试乐观锁
    @Test
    void OptimisticLocker() {
        //根据ID查询数据
        User user = userMapper.selectById(1537608947219124226L);
        //修改
        user.setAge(120);
        userMapper.updateById(user);
    }

    //多个id批量查询
    @Test
    void selectDemo() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 5L, 1537598328570941442L, 1537608947219124226L));
        System.out.println(users);
    }

    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "zjl");
        map.put("age", 22);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

    //分页查询
    @Test
    public void Page() {
        //1 创建page对象
        //传入两个参数：当前页 和 每页显示记录数
        Page<User> page = new Page<>(1, 3);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page, null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal()); //总记录数
        System.out.println(page.getPages()); //总页数

        System.out.println(page.hasNext()); //下一页
        System.out.println(page.hasPrevious()); //上一页
    }


    //删除操作 物理删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1537619576353013762L);
        System.out.println(result);
    }

    //批量删除
    @Test
    public void testDeleteBatchIds() {

        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }


    //mp实现复杂查询操作
    @Test
    public void testSelectQuery() {
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //通过QueryWrapper设置条件
        //ge、gt、le、lt    >= > <= <
        //第一个参数字段名称，第二个参数设置值
        //wrapper.ge("age",30);

        //eq、ne  =    !=
        //wrapper.eq("name","wdxxxw");
        //wrapper.ne("name","wdxxxw");

        //between
        //查询年龄 20-30
        //wrapper.between("age",20,30);

        //like
        //wrapper.like("name","w");

        //orderByDesc
        //wrapper.orderByDesc("id");

        //last
       // wrapper.last("limit 1");

        //指定要查询的列
        wrapper.select("id","name");

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);

    }
}
