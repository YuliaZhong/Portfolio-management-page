package assignment;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PortfolioApplication {
	private static final Logger log = LoggerFactory.getLogger(PortfolioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {

			Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=10", Coin[].class);
			
			// BITCOIN
						Object[] btcRArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("bitcoin")).toArray();
						log.info("Name :" + ((Coin) btcRArray[0]).getName());

						log.info(" Price EUR :" + Double.valueOf(((Coin) btcRArray[0]).getPrice_eur()));


			// Ethereum
			Object[] ethArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("ethereum")).toArray();
			log.info("Name :" + ((Coin) ethArray[0]).getName());

			log.info(" Price EUR :" + Double.valueOf(((Coin) ethArray[0]).getPrice_eur()));

			
		// Ripple
			Object[] xrpArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("eos")).toArray();
		    log.info("Name :" + ((Coin) xrpArray[0]).getName());
			log.info(" Price EUR :" + Double.valueOf(((Coin) xrpArray[0]).getPrice_eur()));

		
			
		};
	}
}
