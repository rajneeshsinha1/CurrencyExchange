package com.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CurrencyExchangeController {

	CurrencyExchange exchangeValue = null;

	@Autowired
	Environment env;

	@Autowired
	ExchangeValueRepository repo;

	@PostMapping("/currencyexchange")
	public CurrencyExchange retrieveExchangeValue(@RequestBody CurrencyExchange exchange) {

		exchangeValue = repo.findByFromAndTo(exchange.getFrom(), exchange.getTo());

		exchangeValue.setQuantity(exchange.getQuantity());
		exchangeValue.setTotalCalculatedAmount(exchangeValue.getMultipleValues().multiply(exchange.getQuantity()));

		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));

		System.out.println(exchangeValue.getId() + "  " + exchangeValue.getFrom() + "   " + exchangeValue.getTo() + "  "
				+ exchangeValue.getMultipleValues() + "  " + exchangeValue.getQuantity() + "  "
				+ exchangeValue.getTotalCalculatedAmount());

		return exchangeValue;

	}

	@GetMapping("/getexchange")
	public CurrencyExchange getCurrencyExchange() {

		return exchangeValue;
	}

}
