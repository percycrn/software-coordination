package com.usst.ten.sc.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.usst.ten.sc.entity.Activity;
import com.usst.ten.sc.entity.Application;
import com.usst.ten.sc.entity.User;
import com.usst.ten.sc.repository.*;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private final UserRepository userRepo;
    private final ActivityRepository activityRepo;
    private final ActivityRecordRepository activityRecordRepo;
    private final TagRepository tagRepo;
    private final ApplicationRepository applicationRepo;

    public Query(UserRepository userRepo, ActivityRepository activityRepo, ActivityRecordRepository activityRecordRepo,
                 TagRepository tagRepo, ApplicationRepository applicationRepo) {
        this.userRepo = userRepo;
        this.activityRepo = activityRepo;
        this.activityRecordRepo = activityRecordRepo;
        this.tagRepo = tagRepo;
        this.applicationRepo = applicationRepo;
    }

    /**
     * 前端业务：管理员：获得所有的用户信息
     * 后端操作：查询获得数据库user表中的所有用户信息（不包括密码）
     * 相关接口：UserRepository
     * 算法实现:
     * 1.通过使用userRepo的findAll()方法获得用户信息列表
     *
     * @return 所有用户信息的列表
     */
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    /**
     * 前端业务：用户：获得所有可报名的活动
     * 后端操作：查询获得数据库activity表中的所有可以报名的活动信息（通过state来判断是否可报名）
     * 相关接口：ActivityRepository
     * 算法实现:
     * 1.通过activityRepo的findByTag()方法获得所有可以报名的活动列表（state为REGISTERING）
     *
     * @return 所有允许用户报名的活动列表
     */
    public List<Activity> unjoinedActivity() {
        return null;
    }

    /**
     * 前端业务：用户：获得个人相关的活动信息
     * 后端操作：查询获得数据库activity表中和该用户相关的所有活动信息
     * 相关接口：ActivityRepository
     * 算法实现:
     * 1.从前端获得用户ID
     * 2.通过activityRepo的findById()的方法获得该用户的所有活动信息
     *
     * @param uid 用户ID
     * @return 某用户已参加的活动列表（包括已报名但未参加的和已参加的）
     */
    public List<Activity> joinedActivity(String uid) {
        return null;
    }

    /**
     * 前端业务：管理员：获得所有未审核的申请信息列表 / 用户：获得本人的申请列表
     * 后端操作：查询获得数据库application表中的所有state为pending的信息列表/查询获得数据库application表中的该用户的所有申请信息
     * 相关接口：ApplicationRepository
     * 算法实现:
     * 1.从前端获取用户ID
     * 2.若ID为NULL，则通过applicationRepo的findByTag()方法获得所有未审核的申请列表
     * 3.若ID不为NULL，则通过applicationRepo的findById()方法获得所有该用户的申请列表
     *
     * @param uid 用户ID
     * @return 所有待管理员审核的申请信息列表 / 用户个人申请信息列表
     */
    public List<Application> getApplication(String uid) {
        return null;
    }
}
