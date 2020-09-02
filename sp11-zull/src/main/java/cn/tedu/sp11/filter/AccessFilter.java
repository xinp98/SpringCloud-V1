package cn.tedu.sp11.filter;

import cn.tedu.web.util.JsonResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.ccache.FileCCacheConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Filter;

/**
 * @Author XinP
 * @Date 2020/9/1 10:20
 */
@Component
public class AccessFilter extends ZuulFilter {

        //过滤器类型   前置  后置  rounting  error
        @Override
        public String filterType() {
            return FilterConstants.PRE_TYPE;
        }
        //顺序号
        //该过滤器顺序要 > 5，才能得到 serviceid
        @Override
        public int filterOrder() {
            return 6;
        }
        //对当前请求是否要进行过滤    返回true，执行run方法
        @Override
        public boolean shouldFilter() {
            //判断用户调用的是否为商品服务
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
            return "item-service".equals(serviceId);

        }
        //过滤代码
        @Override
        public Object run() throws ZuulException {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            String token = request.getParameter("token");
            if (StringUtils.isBlank(token)){
                //没有token，阻止执行
                ctx.setSendZuulResponse(false);
                //想客户端相应
                ctx.setResponseStatusCode(JsonResult.NOT_LOGIN);
                ctx.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).msg("not log in").toString());
            }
            return null;
        }
    }
//    /**
//     * 过滤器类型 pre前置 post后置 routing路由 error错误
//     * @return
//     */
//    @Override
//    public String filterType() {
//        return FilterConstants.PRE_TYPE;
//    }
//
//    /**
//     * 过滤器添加的顺序号(指定过滤器的位置)
//     * 在默认过滤器中,第五个过滤器在上下文对象中添加了service-id
//     * 在第五个过滤器之后才能从上下文对象中访问到service-id
//     * @return
//     */
//    @Override
//    public int filterOrder() {
//        return 6;
//    }
//
//    /**
//     * 对当前请求是否要进行过滤,如果是true会执行run过滤代码
//     * 繁殖则跳过过滤代码,继续执行后面的流程
//     * @return
//     */
//    @Override
//    public boolean shouldFilter() {
//        //判断用户调用的是否是商品服务,如果是的话进行过滤,其他不过滤
//        RequestContext ctx = RequestContext.getCurrentContext();//当前请求上下文对象
//        String serviceId = (String)ctx.get(FilterConstants.SERVICE_ID_KEY);//从上下文对象获取当前调用的service-id进行比较
//        return "item.service".equals(serviceId);
//    }
//
//    /**
//     * 过滤代码
//     * @return 他得返回值在当前Zuul本本中没有启用,返回任何数据都无效
//     * @throws ZuulException
//     */
//    @Override
//    public Object run() throws ZuulException {
//        //
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        String token = request.getParameter("token");
//        if (StringUtils.isBlank(token)){
//            //没有token阻止这次调用继续执行
//            ctx.setSendZuulResponse(false);
//            //向客户端直接发送响应,返回JSONResult对象
//            ctx.setResponseStatusCode(JsonResult.NOT_LOGIN);
//            ctx.setResponseBody(
//                    JsonResult.err()
//                    .code(JsonResult.NOT_LOGIN)
//                    .msg("not log in")
//                    .toString());
//        }
//        return null;
//    }

