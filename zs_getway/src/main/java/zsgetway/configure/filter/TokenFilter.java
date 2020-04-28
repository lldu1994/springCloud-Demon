package zsgetway.configure.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {

    /*
    * pre: 这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在集群中选择请求的微服务，记录调试信息等。
      routing: 这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用apache httpclient或netflix ribbon请求微服务。
      post: 这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的http header、收集统计信息和指标、将响应从微服务发送给客户端等。
      error: 在其他阶段发送错误时执行该过滤器。
    *
    * */

    public boolean shouldFilter() {   //判断过滤器是否生效
        // TODO Auto-generated method stub
        return true;
    }

    public Object run() throws ZuulException {  //编写顾虑器拦截业务逻辑代码
        // 案例：拦截所有都服务接口，判断服务接口上是否有传递userToekn参数
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //验证token时候 token的参数 从请求头获取
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)) {
            //返回错误提示
            currentContext.setSendZuulResponse(false);  //false  不会继续往下执行 不会调用服务接口了 网关直接响应给客户了
            currentContext.setResponseBody("no no no  you have not userToken");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //否则正常执行 调用服务接口...
        return null;
    }

    @Override
    public String filterType() {     //过滤器的类型

        return FilterConstants.PRE_TYPE;   //表示在请求之前执行
    }

    @Override
    public int filterOrder() {  //过滤器执行的顺序 一个请求在同一个阶段存在多个过滤器时候，多个过滤器执行顺序问题
        // TODO Auto-generated method stub
        return 0;
    }
    //网关的filter过滤器
}
