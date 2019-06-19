package demo.mvc.controller;

import demo.mvc.base.MVCConfig;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MVCConfig.class)
@WebAppConfiguration("src/main/resources")
public class TestController {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        //初始化mock
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }


    @Ignore
    public void testHello() {
        try {
            //模拟发起get请求
            mockMvc.perform(get("/index").
                    //请求的协议类型
                            contentType(MediaType.APPLICATION_FORM_URLENCODED).
                    //添加参数
                            param("id", "123")).
                    //对状态做检查
                            andExpect(status().isOk()).
                    //对返回的界面状态做检查
                            andExpect(view().name("index")).
                    //对跳转的页面地址做检查
                            andExpect(forwardedUrl
                            ("/WEB-INF/classes/views/index.jsp"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIntercept() {
        try {
            mockMvc.perform(get("/test/interceptor").contentType(MediaType.APPLICATION_XML).param("msg", "hello").param
                    ("id", "123")).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
