package com.itheima.mybatis_plus_learn;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mybatis_plus_learn.dao.UserDao;
import com.itheima.mybatis_plus_learn.domain.User;

@SpringBootTest
class MybatisPlusLearnApplicationTests {

	@Autowired
	UserDao userDao;
	//----------------------------------------------------------------------------------------CRUD
	// C增加一行数据
	@Test
	void insert() {
		User user = new User();
		user.setId(3L);
		user.setAge(30);
		user.setName("小张");
		user.setPassword("zxcasd123");
		user.setTel("1");
		userDao.insert(user);
	}

	// R获取所有数据
	@Test
	void selectall() {
		List<User> selectList = userDao.selectList(null);
		System.out.println(selectList);
	}

	// U更新一行数据
	@Test
	void update() {
		User user = new User();
		user.setId(1L);
		user.setAge(30);
		user.setName("小张");
		userDao.updateById(user);
	}

	// D删除一行数据
	@Test
	void delete() {
		userDao.deleteById(3L);
	}

	// 分页查询
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	void selectbypage() {
		IPage iPage = new Page<>(1, 2);
		userDao.selectPage(iPage, null);
		System.out.println("当前页码" + iPage.getCurrent());
		System.out.println("每页显示多少条" + iPage.getSize());
		System.out.println("一共多少页" + iPage.getPages());
		System.out.println("一共多少条" + iPage.getTotal());
		System.out.println(iPage.getRecords());
	}

	// --------------------------------------------------------------------------------条件查询
	@Test
	void use_Wapper_To_Query1() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		// lt小于gt大于
		// less than greater than
		wrapper.gt("age", 18);
		List<User> list = userDao.selectList(wrapper);
		System.out.println(list);
	}

	// lambda
	@Test
	void use_Wapper_To_Query2() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		// lt小于gt大于
		// less than greater than
		wrapper.lambda().gt(User::getAge, 18);
		List<User> list = userDao.selectList(wrapper);
		System.out.println(list);
	}

	@Test
	void use_Wapper_To_Query3_Or() {
		LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
		// 并且的写法，查询大于18且小于100
		// wrapper.gt(User::getAge, 18).lt(User::getAge, 100);
		wrapper.gt(User::getAge, 18).or().lt(User::getAge, 100);
		List<User> list = userDao.selectList(wrapper);
		System.out.println(list);
	}
}
