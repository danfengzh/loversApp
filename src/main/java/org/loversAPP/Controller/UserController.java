package org.loversAPP.Controller;

import org.loversAPP.Controller.base.BaseController;
import org.loversAPP.Controller.utils.ControllerConstant;
import org.loversAPP.Controller.utils.InviteCodeCreator;
import org.loversAPP.Controller.utils.fileUpload;
import org.loversAPP.DTO.FeedBack;
import org.loversAPP.DTO.location;
import org.loversAPP.Jpush.JpushClientUtil;
import org.loversAPP.model.FinishStatus;
import org.loversAPP.model.LoverShip;
import org.loversAPP.model.User;
import org.loversAPP.service.LoverShipService;
import org.loversAPP.service.UserService;
import org.loversAPP.service.finishStatusService;
import org.loversAPP.service.messageService;
import org.loversAPP.utils.MD5Utils;
import org.loversAPP.utils.UniqueStringGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */
@Controller
@RequestMapping("/User")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoverShipService loverShipService;
    @Autowired
    private messageService messageService;
    @Autowired
    private finishStatusService finishStatusService;

    /**
     * 根据用户id查询用户个人信息
     *
     * @param userID
     * @return
     */
    @RequestMapping(value = "getUserByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<User> getUserByID(@RequestParam("id") Integer userID) {
        FeedBack<User> feedBack;
        User user = userService.getUserByID(userID);
        if (user != null) {
            feedBack = new FeedBack<User>("查询成功", "200", user);
        } else {
            feedBack = new FeedBack<User>("查询失败，不存在该用户", "200", user);
        }

        return feedBack;
    }

    /**
     * 根据电话号码和密码查询用户id
     *
     * @param phoneNumber
     * @param passWord
     * @return
     */

    @RequestMapping(value = "getIDByPhoneAndPw", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> getIDByPhoneAndPw(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("passWord") String passWord) {
        String md5Pass = MD5Utils.getMd5(passWord);
        Integer res = userService.getIDByPhoneAndPw(phoneNumber, md5Pass);
        FeedBack<Integer> feedBack;

        feedBack = new FeedBack<Integer>(FeedBack.OK_STR, "200", res);
        return feedBack;
    }

    /**
     * 查询所有的用户
     *
     * @return
     */

    @RequestMapping(value = "getAllUsers", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<List<User>> getAllUsers() {

        FeedBack<List<User>> feedBack;
        List<User> users = userService.getAllUsers();
        feedBack = new FeedBack(FeedBack.OK_STR, "200", users);
        return feedBack;
    }

    /**
     * 增加用户
     *
     * @return
     */

    @RequestMapping(value = "insertUser", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public FeedBack<Integer> insertUser(User user) {
        //对用户名和电话进行检测

        FeedBack<Integer> feedBack;
        //记得对用户的密码进行加密
        User us = userService.isExistUser(user.getUsername(), user.getPhonenumber());

        if (us != null && us.getUsername().equals(user.getUsername())) {
            feedBack = new FeedBack("the userName is exits", "101");
        } else if (us != null && us.getPhonenumber().equals(user.getPhonenumber())) {
            feedBack = new FeedBack("the phoneNumer is exits", "102");
        } else {
            String md5pass = MD5Utils.getMd5(user.getPassword());
            String inviteCode = InviteCodeCreator.createRandom(true, 6);
            user.setPassword(md5pass);
            user.setInvitecode(inviteCode);
            user.setRegdate(new Date());
            Integer count = userService.insertUser(user);

            Integer maxID = userService.getUserByInviteCode(inviteCode).getId();
            finishStatusService.finishStatus(maxID);
            if (count == 1) {
                feedBack = new FeedBack("OK", "200", maxID);
            } else {
                feedBack = new FeedBack("FAILURE", "500");
            }
        }
        return feedBack;
    }

    @RequestMapping(value = "getFinishStatusByUID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<FinishStatus> getFinishStatusByUID(Integer id) {
        FeedBack<FinishStatus> feedBack;
        FinishStatus finishStatus = finishStatusService.getFinishStatusByUID(id);
        if (finishStatus != null) {
            feedBack = new FeedBack("success", "200", finishStatus);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "setFinishStatusByUID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> setFinishStatusByUID(Integer id, Integer status) {

        int res = finishStatusService.setFinishStatusByUID(id, status);
        return new FeedBack("success", "200", status);
    }

    /**
     * 根据用户id更新密码  ---有问题
     *
     * @param id
     * @param password
     * @return
     */

    @RequestMapping(value = "updatePwByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updatePwByID(@RequestParam("id") Integer id, @RequestParam("passWord") String password) {
        FeedBack<String> feedBack;
        //对用户密码进行更新之后在进行插入
        String md5Pass = MD5Utils.getMd5(password);
        int count = userService.updatePwByID(id, md5Pass);
        if (count == 1) {
            feedBack = new FeedBack<String>("success", "100", md5Pass);
        } else {
            feedBack = new FeedBack<String>("FAILURE", "500");
        }
        return feedBack;
    }

    /**
     * @param avatar 用户头像文件流
     * @param id     用户id
     * @return
     */

    @RequestMapping(value = "updateAvatarByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateAvatarByID(@RequestParam("id") Integer id, @RequestParam("avatar") MultipartFile avatar) {
        FeedBack<String> feedBack;

        //对文件进行保存处理
        String avatorPath = getMessage(ControllerConstant.userAvatorPath);
        User user = userService.getUserByID(id);
        if (user.getAvator() != null) {
            File filePresious = new File(request.getSession().getServletContext().getRealPath(File.separator) + "/" + user.getAvator());
            if (filePresious != null && filePresious.exists()) {
                filePresious.delete();
            }
        }
        String newAvatorpath = fileUpload.tacleUpload(avatar, avatorPath, request, MD5Utils.getMd5(user.getPhonenumber()));
        int count = userService.updateAvatarByID(id, newAvatorpath);
        if (count == 1) {
            feedBack = new FeedBack<String>("success", "200", newAvatorpath);
        } else {
            feedBack = new FeedBack<String>("failure", "500");
        }

        return feedBack;
    }

    @RequestMapping(value = "updateUserNameByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateUserNameByID(@RequestParam("id") Integer id, @RequestParam("userName") String userName) {
        FeedBack<String> feedBack;
        int count = userService.updateUserNameByID(id, userName);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", userName);
        } else {
            feedBack = new FeedBack("failure", "400");
        }
        return feedBack;
    }

    /**
     * 对此方法进行改进，主要看isAvailable 是否为1，如果为1，返回成功并且执行insertLoverShip操作，如果为0，返回失败
     *
     * @param inviteCode
     * @return
     */
    @RequestMapping(value = "getUserByInviteCode", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> getUserByInviteCode(@RequestParam("inviteCode") String inviteCode, @RequestParam("id") Integer id) {
        FeedBack<Integer> feedBack;
        final User user = userService.getUserByInviteCode(inviteCode);
        if (user != null) {

            //同时需要检测loverShip是否可用 --也就是邀请者的id是否在loverShip里面已经有了
            String loverID = loverShipService.getloveIDByID(user.getId());
            String lovserID2 = loverShipService.getloveIDByID(id);
            //同时插入消息 方便发送

            if (loverID == null && lovserID2 == null) {     //给被邀请者发消息
                int flag = messageService.insertMessage(id, user.getId(), "1", new Date(), "匹配成功");
                try {
                    JpushClientUtil.sendDynatic(String.valueOf(user.getId()), String.valueOf(user.getId()), "你有一条消息提醒", "tips",
                            "1", "匹配成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LoverShip loverShip = new LoverShip();
                loverShip.setState(1);
                loverShip.setLovergirlid(id);//邀请人id
                loverShip.setLoverboyid(user.getId());//被邀请人id
                loverShip.setLoverid(UniqueStringGenerate.generateRandomStr(8));
                loverShip.setLovetime(new Date());
                int count = loverShipService.insertLoverShip(loverShip);
                feedBack = new FeedBack("success", "200", id);
            } else {
                feedBack = new FeedBack("failure", "201");
            }
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    /**
     * 删除用户的时候需要将和该用户有关的信息都进行删除
     * 1.解除恋爱关系---也就是删除lover_ship关系--附加删除activity_records
     * 2.删除道具信息
     * 3.删除宝藏信息
     * 4.删除dig_history
     *
     * @param userID
     * @return
     */
    @RequestMapping(value = "deleteUserByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> deleteUserByID(@RequestParam("id") Integer userID) {
        FeedBack<String> feedBack;
        Integer count = userService.deleteUserByID(userID);
        if (count == 1) {
            feedBack = new FeedBack("success", "200");
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateSexByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateSexByID(@RequestParam("id") Integer id, @RequestParam("sex") String sex) {
        FeedBack<String> feedBack;
        Integer count = userService.updateSexByID(id, sex);
        if (count == 1) {
            feedBack = new FeedBack("success", "200");
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateSignatureByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateSignatureByID(@RequestParam("id") Integer id, @RequestParam("signature") String signature) {
        FeedBack<String> feedBack;
        Integer count = userService.updateSignatureByID(id, signature);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", signature);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateStepsTodayByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateStepsTodayByID(@RequestParam("id") Integer id, @RequestParam("stepsToday") Integer stepsToday) {
        FeedBack<Integer> feedBack;
        Integer count = userService.updateStepsTodayByID(id, stepsToday);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", stepsToday);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateLocationByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack updateStepsTodayByID(@RequestParam("id") Integer id, @RequestParam("longtitude") String longtitude, @RequestParam("latitude") String latitude) {
        FeedBack feedBack;
        Integer count = userService.updateLocationByID(id, longtitude, latitude);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", new location(longtitude, latitude));
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateWexIDByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateWexIDByID(@RequestParam("id") Integer id, @RequestParam("wexID") String wexID) {
        FeedBack<String> feedBack;
        int count = userService.updateWexIDByID(id, wexID);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", wexID);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateQQByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateQQByID(@RequestParam("id") Integer id, @RequestParam("qq") String qq) {
        FeedBack<String> feedBack;
        int count = userService.updateQQByID(id, qq);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", qq);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateLevelByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateLevelByID(@RequestParam("id") Integer id, @RequestParam("level") Integer level) {
        FeedBack<Integer> feedBack;
        int count = userService.updateLevelByID(id, level);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", level);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateStatusByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateStatusByID(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        FeedBack<Integer> feedBack;
        int count = userService.updateStayus(id, status);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", status);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateCheckinDaysByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateCheckinDaysByID(@RequestParam("id") Integer id, @RequestParam("checkinDays") Integer checkinDays) {
        FeedBack<Integer> feedBack;
        int count = userService.updateCheckinDaysByID(id, checkinDays);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", checkinDays);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateAgeByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateAgeByID(@RequestParam("id") Integer id, @RequestParam("age") Integer age) {
        FeedBack<Integer> feedBack;
        int count = userService.updateAgeByID(id, age);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", age);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateHeightByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateHeightByID(@RequestParam("id") Integer id, @RequestParam("height") Integer height) {
        FeedBack<Integer> feedBack;
        int count = userService.updateHeightByID(id, height);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", height);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateWeightByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateWeightByID(@RequestParam("id") Integer id, @RequestParam("weight") Integer weight) {
        FeedBack<Integer> feedBack;
        int count = userService.updateWeightByID(id, weight);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", weight);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateHobbyByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateHobbyByID(@RequestParam("id") Integer id, @RequestParam("hobby") String hobby) {
        FeedBack<String> feedBack;
        int count = userService.updateHobbyByID(id, hobby);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", hobby);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateExpByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateExpByID(@RequestParam("id") Integer id, @RequestParam("exp") Integer exp) {
        FeedBack<Integer> feedBack;
        int count = userService.updateExpByID(id, exp);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", exp);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateBimgByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> updateBimgByID(@RequestParam("id") Integer id, @RequestParam("backImage") MultipartFile backImage) {
        String homePicPath = getMessage(ControllerConstant.userHomePicParg);
        User user = userService.getUserByID(id);
        File filePresious = null;
        if (user.getBackimage() != null) {
            filePresious = new File(request.getSession().getServletContext().getRealPath(File.separator) + "/" + user.getBackimage());
        }
        if (filePresious != null && filePresious.exists()) {
            filePresious.delete();
        }
        String newBackPathpath = fileUpload.tacleUpload(backImage, homePicPath, request, MD5Utils.getMd5(user.getPhonenumber()));
        FeedBack<String> feedBack;
        int count = userService.updateBimgByID(id, newBackPathpath);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", newBackPathpath);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "getInviteCodeByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<String> getInviteCodeByID(@RequestParam("id") Integer id) {
        FeedBack<String> feedBack;
        String inviteCode = userService.getInviteCodeByID(id);
        if (inviteCode != null) {
            feedBack = new FeedBack("success", "200", inviteCode);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

    @RequestMapping(value = "updateMoneyByID", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public FeedBack<Integer> updateMoneyByID(@RequestParam("id") Integer id, @RequestParam("money") Integer money) {
        FeedBack<Integer> feedBack;
        int count = userService.updateMoneyByID(id, money);
        if (count == 1) {
            feedBack = new FeedBack("success", "200", money);
        } else {
            feedBack = new FeedBack("failure", "500");
        }
        return feedBack;
    }

}

