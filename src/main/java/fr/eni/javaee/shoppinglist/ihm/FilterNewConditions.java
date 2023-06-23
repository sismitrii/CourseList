package fr.eni.javaee.shoppinglist.ihm;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterNewConditions
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class FilterNewConditions extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterNewConditions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		RequestDispatcher rd = request.getRequestDispatcher("/pages/NewConditions.jsp");

		
		Cookie[] cookies = hsr.getCookies();
		Cookie c = null;
		if (cookies != null) {
			c = Arrays.asList(cookies).stream().filter(x -> "conditionAccepted".equals(x.getName())).findFirst().orElse(null);
		}
		
		if ( c != null && "true".equals(c.getValue())) {
			chain.doFilter(request, response);
		} else {
			String checked = hsr.getParameter("inputCondition");
			
			if (checked != null && "on".equals(checked)) {
				//cree le cookie 
				Cookie newCookie = new Cookie("conditionAccepted", "true");
				httpServletResponse.addCookie(newCookie);
				
				httpServletResponse.sendRedirect(hsr.getContextPath()+ "/Homepage");
			} else {
				rd.forward(request, response);

			}
			
		}


		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
