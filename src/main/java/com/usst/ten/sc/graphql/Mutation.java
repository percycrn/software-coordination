package com.usst.ten.sc.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.usst.ten.sc.entity.Activity;
import com.usst.ten.sc.entity.Application;
import com.usst.ten.sc.entity.User;
import com.usst.ten.sc.pojo.*;
import com.usst.ten.sc.repository.*;

//Mutation类的描述:该类包含了本系统中所有需要修改数据库数据的方法。
public class Mutation implements GraphQLMutationResolver {

    // 属性定义
    private final UserRepository userRepo;
    private final ActivityRepository activityRepo;
    private final ActivityRecordRepository activityRecordRepo;
    private final TagRepository tagRepo;
    private final ApplicationRepository applicationRepo;

    public Mutation(UserRepository userRepo, ActivityRepository activityRepo,
                    ActivityRecordRepository activityRecordRepo, TagRepository tagRepo,
                    ApplicationRepository applicationRepo) {
        this.userRepo = userRepo;
        this.activityRepo = activityRepo;
        this.activityRecordRepo = activityRecordRepo;
        this.tagRepo = tagRepo;
        this.applicationRepo = applicationRepo;
    }

    /**
     * 前端业务：用户：登录
     * 后端操作：向数据库查询相应的手机号和密码
     * 相关接口：UserRepository
     * 算法实现:
     * 1.从前端获取登录的手机号和密码
     * 2.通过userRepo的findByPhoneNumber()方法查询user表中数据，获得用户信息
     * 3.对比password正确与否返回信息，信息正确返回的用户对象不为null，不正确返回的errorMessage有内容
     *
     * @param signData 用户登录信息：手机号、密码
     * @return 用户信息，错误信息和用户已参加的信息
     */
    public LoginResponse signIn(SignData signData) {
        return null;
    }

    /**
     * 前端业务：用户：注册
     * 后端操作：向数据库user表中插入一个新的元组
     * 相关接口：UserRepository
     * 算法实现:
     * 1.从前端获取注册信息：手机号和密码
     * 2.通过userRepo的findByPhoneNumber()方法查询数据库user表中是否存在相同phoneNumber的元组，找到则返回错误信息(errorMessage)
     * 3.实例化一个新的User对象
     * 4.用userRepo的save()方法向表中插入新的元组
     *
     * @param signData 用户登录信息：手机号、密码
     * @return 用户信息，错误信息和用户已参加的信息
     */
    public LoginResponse signUp(SignData signData) {
        return null;
    }

    /**
     * 前端业务：用户：登出
     * 后端操作：更新user表中该用户的登录标志字段
     * 相关接口：UserRepository
     * 算法实现:
     * 1.从前端获取用户手机号
     * 2.通过userRepo的findByPhoneNumber()的方法获得该用户对象
     * 3.修改该用户对象的登录属性
     * 4.通过userRepo的save()方法保存（覆盖）该用户信息
     *
     * @param signData 用户登录信息：手机号、密码
     */
    public void signOut(SignData signData) {

    }

    /**
     * 前端业务：管理员：添加新的activity
     * 后端操作：向数据库activity表中插入一个新的元组
     * 相关接口：ActivityRepository
     * 算法实现:
     * 1.从前端获取活动信息
     * 2.实例化一个Activity对象
     * 3.使用activityRepo自带的save()方法，将数据插入数据库
     *
     * @param activityInfo 活动信息：用户ID、活动ID、活动信息
     * @return 创建的活动的信息
     */
    public Activity createActivity(ActivityInfo activityInfo) {
        return null;
    }

    /**
     * 前端业务：管理员：删除一个已有的activity
     * 后端操作：通过ID删除数据库activity表中的一个元组
     * 相关接口：ActivityRepository
     * 算法实现:
     * 1.从前端获取待删除的活动ID
     * 2.使用activityRepo自带的deleteById()方法，从数据库中删除
     *
     * @param activityInfo 活动信息：用户ID、活动ID、活动信息
     * @return 删除的活动的信息
     */
    public Activity deleteActivity(ActivityInfo activityInfo) {
        return null;
    }

    /**
     * 前端业务：管理员修改一个已存在的activity
     * 后端操作：通过ID修改数据库activity表中的一个元组
     * 相关接口：ActivityRepository
     * 算法实现:
     * 1.从前端获取活动信息
     * 2.实例化一个Activity对象
     * 3.使用activityRepo自带的save()方法，从数据库修改（覆盖）活动信息
     *
     * @param activityInfo 活动信息：用户ID、活动ID、活动信息
     * @return 更新的活动的信息
     */
    public Activity updateActivity(ActivityInfo activityInfo) {
        return null;
    }

    /**
     * 前端业务：用户：修改个人信息
     * 后端操作：通过ID向数据库user表中查询元组并更新
     * 相关接口：UserRepository
     * 算法实现:
     * 1.从前端获取待更新的用户信息：邮箱、地址
     * 2.通过uid查找相对应的用户元组，未找到则返回null
     * 3.实例化一个新的User对象
     * 4.通过userRepo的save()方法修改（覆盖）表中数据
     *
     * @param userInfo 用户信息：用户ID、用户Email、用户住址
     * @return 更新的用户的信息
     */
    public User updateUserInfo(UserInfo userInfo) {
        return null;
    }

    /**
     * 前端业务：用户：活动报名
     * 后端操作：向数据库activityRecord表中插入一个新的元组
     * 相关接口：ActivityRecordRepository & ActivityRepository
     * 算法实现:
     * 1.从前端获取活动ID和用户ID
     * 2.实例化一个新的ActivityRecord的对象
     * 3.通过调用activityRecordRepo的save()方法保存新的活动记录(ActivityRecord)
     * 4.通过activityRepo的findById()方法获得该活动信息
     *
     * @param activityInfo 活动信息：用户ID、活动ID、活动信息
     * @return 用户报名的活动的信息
     */
    public Activity createActivityUser(ActivityInfo activityInfo) {
        return null;
    }

    /**
     * 前端业务：用户：取消报名
     * 后端操作：通过用户ID和活动ID删除数据库activityRecord表中的一个元组
     * 相关接口：ActivityRepository & ActivityRecordRepository
     * 算法实现:
     * 1.从前端获取用户ID和活动ID
     * 2.通过activityRecordRepo自定义的deleteByActivityIdAndUserId()删除该元组
     * 3.通过activityRepo的findById()方法获得该活动信息
     *
     * @param activityInfo 活动信息：用户ID、活动ID、活动信息
     * @return 用户取消报名的活动的信息
     */
    public Activity deleteActivityUser(ActivityInfo activityInfo) {
        return null;
    }

    /**
     * 前端业务：用户：活动签到
     * 后端操作：通过用户ID和活动ID更新数据库activityRecord表中的一个元组
     * 相关接口：ActivityRecordRepository & ActivityRepository
     * 算法实现:
     * 1.从前端获取用户ID和活动ID
     * 2.实例化一个ActivityRecord对象
     * 3.通过activityRecordRepo的save()方法覆盖原来的活动记录
     * 4.通过activityRepo的findById()方法获得该活动信息
     *
     * @param activityInfo 活动信息：用户ID、活动ID、活动信息
     * @return 用户签到
     */
    public Activity updateActivityUser(ActivityInfo activityInfo) {
        return null;
    }

    /**
     * 前端业务：用户：申请新的身份
     * 后端操作：向数据库application表中插入一个元组
     * 相关接口：ApplicationRepository
     * 算法实现:
     * 1.从前端获取用户ID，标签tag和申请时间
     * 2.实例化一个Application对象
     * 3.通过applicationRepo的save()方法插入该元组
     *
     * @param applicationInfo 申请信息：用户ID、标签名、申请时间、申请状态
     * @return 用户新申请的信息
     */
    public Application createApp(ApplicationInfo applicationInfo) {
        return null;
    }

    /**
     * 前端业务：用户：取消申请
     * 后端操作：通过用户ID和申请tag删除数据库application表中的一个元组
     * 相关接口：ApplicationRepository
     * 算法实现:
     * 1.从前端获取用户ID和申请tag
     * 2.通过applicationRepo的deleteByUidAndTag()方法删除该元组
     *
     * @param applicationInfo 申请信息：用户ID、标签名、申请时间、申请状态
     * @return 用户删除的申请的信息
     */
    public Application deleteApp(ApplicationInfo applicationInfo) {
        return null;
    }

    /**
     * 前端业务：管理员审核申请表
     * 后端操作：通过用户ID和申请状态更新数据库application表中的元组
     * 相关接口：ApplicationRepository
     * 算法实现:
     * 1.从前端获取用户ID，申请状态
     * 2.实例化一个Application的对象
     * 3.通过使用applicationRepo的save()方法覆盖原来的元组
     *
     * @param applicationInfo 申请信息：用户ID、标签名、申请时间、申请状态
     * @return 管理员更新用户申请状态后的申请的信息
     */
    public Application updateApp(ApplicationInfo applicationInfo) {
        return null;
    }
}
