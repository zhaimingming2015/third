package com.dri.filter;



import javax.servlet.http.HttpServletRequest;



import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyFilter extends ZuulFilter {
	


	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        //log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            //log.warn("access token is empty");
            System.out.println("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("lack access token");
            ctx.setResponseStatusCode(401);
            return null;
        }
        System.out.println("access token ok");
        
        return null;
	}

	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，
	 * 具体如下：自定义过滤器的实现，需要继承ZuulFilter，需要重写实现下面四个方法
	 * 	pre：可以在请求被路由之前调用
	 *	routing：在路由请求时候被调用
	 *	post：在routing和error过滤器之后被调用
	 *	error：处理请求时发生错误时被调用
	 *	
	 *	filterOrder：通过int值来定义过滤器的执行顺序
	 *	shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效。
	 * 
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
