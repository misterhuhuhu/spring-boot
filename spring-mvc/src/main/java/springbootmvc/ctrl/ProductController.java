package springbootmvc.ctrl;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import springbootmvc.model.Product;
import springbootmvc.svc.ProductService;

import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;
import static org.springframework.web.servlet.function.ServerResponse.status;

@Component
public class ProductController {

    public RouterFunction<ServerResponse> productListing(ProductService ps) {
        return route().GET("/product", req -> ok().body(ps.findAll()))
            .build();
    }

    public RouterFunction<ServerResponse> productSearch(ProductService ps) {
        return route().nest(RequestPredicates.path("/product"), builder -> {
            builder.GET("/name/{name}", req -> ok().body(ps.findByName(req.pathVariable("name"))))
                .GET("/id/{id}", req -> ok().body(ps.findById(Integer.parseInt(req.pathVariable("id")))));
        })
            .onError(ProductService.ItemNotFoundException.class, (e, req) -> EntityResponse.fromObject(new Error(e.getMessage()))
                .status(HttpStatus.NOT_FOUND)
                .build())
            .build();
    }
    
    /**
     * 实现身份验证
     * @param ps
     * @return
     */
    public RouterFunction<ServerResponse> adminFunctions(ProductService ps) {
        return route().POST("/product", req -> ok().body(ps.save(req.body(Product.class))))
            .filter((req, next) -> authenticate(req) ? next.handle(req) : status(HttpStatus.UNAUTHORIZED).build())
            .onError(IllegalArgumentException.class, (e, req) -> EntityResponse.fromObject(new Error(e.getMessage()))
                .status(HttpStatus.BAD_REQUEST)
                .build())
            .build();
    }

    public RouterFunction<ServerResponse> remainingProductRoutes(ProductService ps) {
        return route().add(productSearch(ps))
            .add(adminFunctions(ps))
            .build();
    }

    private boolean authenticate(ServerRequest req) {
        return Boolean.TRUE;
    }

}
