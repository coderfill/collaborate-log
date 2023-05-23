
package com.collaborate.demo;

/**
 * @Copyright 2020-2030,360 Group(https://www.360.cn/) All rights reserved.
 * <p>
 * Copyright ownership belongs to 360 Group, shall not be reproduced,
 * copied, or used in other ways without permission.
 * Otherwise 360 Group will have the right to pursue legal responsibilities.
 * @Description CollaborateMessage服务测试用例
 * @Author wanghuabing
 * @Date 2020-12-01 15:18:06
 * @Version 1.0
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//@AutoConfigureMockMvc
public class TuituiMessageTest {

//    @Resource
//    private MockMvc mockMvc;
//
//    @Resource
//    private WebApplicationContext webApplicationContext;
//
//
//    @Resource
//    private TuituiMessageApi tuituiMessageApi;
//
//    @Resource
//    private TuituiConfig tuituiConfig;
//
//    @Resource
//    private TuituiMessageServiceImpl service;
//
//    @Resource
//    private MessageLogServiceImpl messageLogService;
//
//
//
//    private ApprovalMessageReq approvalMessageReq = new ApprovalMessageReq();
//    private String approvalMessageSendUrl = "/collaborate/message/approval/send";
//
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        /**
//         * 初始化审批消息请求
//         * 单元测试脚本只对审批消息发送功能以及消息内容进行验证，并不包含链接跳转部分
//         * 每个消息场景的{@link ApprovalMessageReq#setPlatform(String)}值均为<value>BPM</value>
//         * 验证的审批消息范围包括：
//         * <pre>
//         *     待审批消息
//         *     已审批消息
//         *     审批通过消息
//         *     审批拒绝消息
//         *     通过消息
//         *     驳回消息
//         *     滴滴打车报销单待审批消息
//         *     滴滴打车报销单已审批消息
//         * </pre>
//         */
//        log.info("初始化审批消息请求对象, start......");
//        String bizId = UUID.randomUUID().toString();
//        String applyTime = DateUtil.format(DateTime.now().toDate(), "yyyy-MM-dd HH:mm:ss");
//        approvalMessageReq.setApprovalId(bizId);
//        approvalMessageReq.setTitle("单元测试脚本--消息测试" + bizId);
//        approvalMessageReq.setBillno(bizId);
//
//        approvalMessageReq.setApplyDateTime(applyTime);
//        approvalMessageReq.setApplyUser("测试账号");
//        approvalMessageReq.setApproveDomain("fangzizhong");
//        approvalMessageReq.setFromUserName("方梓仲");
//        approvalMessageReq.setFromUserDomain("fangzizhong");
//
//        approvalMessageReq.setMsgType(Category.APPROVAL.getValue());
//        approvalMessageReq.setPlatform("BPM");
//        /**
//         * showType：
//         * 1：PC端可以查看处理
//         * 3：移动端可以查看处理
//         * 4：业务系统查看处理
//         */
//        approvalMessageReq.setShowType(0);
//        approvalMessageReq.setDetailUrl("https://www.baidu.com");
//        log.info("初始化审批消息请求对象, finish，value:{}", JSONObject.toJSONString(approvalMessageReq));
//    }
//
//
//    @Test
//    public void approvalMessage() throws Exception {
//        log.info("approvalmessage start......");
//        todo();
//        done();
//        communicationDone();
//        log.info("approvalmessage finish, ok......");
//    }
//
//
//    @Test
//    public void api() throws Exception {
//        log.info("api start......");
//        send();
//        log.info("api finish, ok.......");
//    }
//
//
//
//    protected void send() throws Exception {
//        TuituiRequest request = new TuituiRequest();
//        request.setAppId(tuituiConfig.getAppId());
//        request.setSecret(tuituiConfig.getSecret());
//        request.setToUsers("dongbo1");
//        request.setKey("demo");
//        request.setBizId("10000000");
//        request.setMsgType(MsgType.tuitui);
//        request.setAsync(true);
//        request.setRequestType(RequestType.REST);
//
//        List<MessageLabel> labels = new ArrayList<>();
//        labels.add(new MessageLabel("title", "客户端测试消息"));
//        labels.add(new MessageLabel("applyUser", "方梓仲"));
//        labels.add(new MessageLabel("platform", "测试平台"));
//
//
//        request.setLabels(labels.toArray(new MessageLabel[labels.size()]));
//        service.send(request);
////        tuituiMessageApi.send(request);
//    }
//
//
//
//    /**
//     * 待审批消息验证
//     * <p>
//     *     {@link ApprovalMessageReq#setMsgType(int)}值为<value>1</value>
//     * </p>
//     */
//    protected void todo() throws Exception {
//        approvalMessageReq.setMsgType(Category.APPROVAL.getValue());
//        String ret = push(approvalMessageReq);
//        JsonResult json = JSONObject.parseObject(ret, JsonResult.class);
//        String domain = approvalMessageReq.getApproveDomain();
//
//        MessageLog messageLog = messageLogService.getApprovalLog(approvalMessageReq.getApprovalId(),
//                approvalMessageReq.getPlatform(), MessageType.TuiTui, domain);
//        Assert.assertNotNull("没有找到待审批的消息日志", messageLog);
//
//        Assert.assertEquals("发送待审批消息，服务端返回值不是200", 200, json.getCode());
//        Assert.assertTrue("发送待审批消息，服务端返回值isSuccess为false", json.isSuccess());
//        try {
//            if (!Objects.isNull(json.getData())) {
//                Result data = JSONObject.parseObject(json.getData().toString(), Result.class);
//                Assert.assertEquals("发送待审批消息，服务端返回Status状态不是Status.OK", Status.OK, data.getStatus());
//            }
//        } catch (Exception e) {
//            Assert.fail("待审批消息，从JsonResult中获取data时，处理Result对象出现异常");
//        }
//    }
//
//
//    /**
//     * 已审批消息验证
//     * @throws Exception
//     */
//    protected void done() throws Exception {
//        approvalMessageReq.setMsgType(Category.DONE.getValue());
//        String ret = push(approvalMessageReq);
//        JsonResult json = JSONObject.parseObject(ret, JsonResult.class);
//
//        List<MessageLog> logs = messageLogService.getLogs(approvalMessageReq.getApprovalId(), approvalMessageReq.getPlatform(), MessageType.TuiTui);
//        boolean hasDone = false;
//        for (MessageLog l : logs) {
//            if (StringUtils.equals(l.getStatus(), Category.DONE.getName())) {
//                hasDone = true;
//                continue;
//            }
//        }
//        Assert.assertTrue("没有找到已审批状态的消息日志", hasDone);
//
//        Assert.assertEquals("发送已审批消息，服务端返回值不是200", 200, json.getCode());
//        Assert.assertTrue("发送已审批消息，服务端返回值isSuccess为false", json.isSuccess());
//        try {
//            if (!Objects.isNull(json.getData())) {
//                Result data = JSONObject.parseObject(json.getData().toString(), Result.class);
//                Assert.assertEquals("发送已审批消息，服务端返回Status状态不是Status.OK", Status.OK, data.getStatus());
//            }
//        } catch (Exception e) {
//            Assert.fail("已审批消息，从JsonResult中获取data时，处理Result对象出现异常");
//        }
//    }
//
//
//    /**
//     * 沟通回复消息
//     * @throws Exception
//     */
//    protected void communicationDone() throws Exception {
//        approvalMessageReq.setMsgType(Category.COMMUNATION_DONE.getValue());
//        String ret = push(approvalMessageReq);
//        JsonResult json = JSONObject.parseObject(ret, JsonResult.class);
//        String domain = approvalMessageReq.getApproveDomain();
//
//        MessageLog messageLog = messageLogService.getApprovalLog(approvalMessageReq.getApprovalId(),
//                approvalMessageReq.getPlatform(), MessageType.TuiTui, domain);
//        Assert.assertNotNull("没有找到回复沟通的消息日志", messageLog);
//
//        Assert.assertEquals("发送回复沟通消息，服务端返回值不是200", 200, json.getCode());
//        Assert.assertTrue("发送回复沟通批消息，服务端返回值isSuccess为false", json.isSuccess());
//        try {
//            if (!Objects.isNull(json.getData())) {
//                Result data = JSONObject.parseObject(json.getData().toString(), Result.class);
//                Assert.assertEquals("发送回复沟通消息，服务端返回Status状态不是Status.OK", Status.OK, data.getStatus());
//            }
//        } catch (Exception e) {
//            Assert.fail("回复沟通消息，从JsonResult中获取data时，处理Result对象出现异常");
//        }
//    }
//
//
//    protected String push(ApprovalMessageReq request) throws Exception {
//        String ret = mockMvc.perform(
//                        MockMvcRequestBuilders.post(approvalMessageSendUrl)
//                                .content(JSONObject.toJSONString(request))
//                                .contentType(MediaType.APPLICATION_JSON)
//                ).andReturn()
//                .getResponse()
//                .getContentAsString();
//        return ret;
//    }
}

