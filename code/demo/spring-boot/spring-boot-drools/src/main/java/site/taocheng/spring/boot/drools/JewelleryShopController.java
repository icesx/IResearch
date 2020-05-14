/**
 * Program  : D.java<br/>
 * Author   : i<br/>
 * Create   : Apr 29, 2020 9:17:21 AM<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package site.taocheng.spring.boot.drools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JewelleryShopController {

	private final JewelleryShopService jewelleryShopService;

	@Autowired
	public JewelleryShopController(JewelleryShopService jewelleryShopService) {
		this.jewelleryShopService = jewelleryShopService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {

		Product product = new Product();
		product.setType(type);
		jewelleryShopService.getProductDiscount(product);
		return product;
	}
}