/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package videoshop.catalog;

import static org.salespointframework.core.Currencies.*;

import videoshop.catalog.Disc.DiscType;

import org.javamoney.moneta.Money;
import org.salespointframework.core.DataInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * A {@link DataInitializer} implementation that will create dummy data for the application on application startup.
 *
 * @author Paul Henke
 * @author Oliver Gierke
 * @see DataInitializer
 */
@Component
@Order(20)
class CatalogDataInitializer implements DataInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(CatalogDataInitializer.class);

	private final VideoCatalog videoCatalog;

	CatalogDataInitializer(VideoCatalog videoCatalog) {

		Assert.notNull(videoCatalog, "VideoCatalog must not be null!");

		this.videoCatalog = videoCatalog;
	}

	/*
	 * (non-Javadoc)
	 * @see org.salespointframework.core.DataInitializer#initialize()
	 */
	@Override
	public void initialize() {

		if (videoCatalog.findAll().iterator().hasNext()) {
			return;
		}

		LOG.info("Creating default catalog entries.");

		videoCatalog.save(new Disc("Last Action Hero", "lac", Money.of(100, EURO), "Äktschn/Comedy", DiscType.DVD));
		videoCatalog.save(new Disc("Back to the Future", "bttf", Money.of(9.99, EURO), "Sci-Fi", DiscType.DVD));
		videoCatalog.save(new Disc("Fido", "fido", Money.of(9.99, EURO), "Comedy/Drama/Horror", DiscType.DVD));
		videoCatalog.save(new Disc("Super Fuzz", "sf", Money.of(9.99, EURO), "Action/Sci-Fi/Comedy", DiscType.DVD));
		videoCatalog.save(new Disc("Armour of God II: Operation Condor", "aog2oc", Money.of(14.99, EURO),
				"Action/Adventure/Comedy", DiscType.DVD));
		videoCatalog.save(new Disc("Persepolis", "pers", Money.of(14.99, EURO), "Animation/Biography/Drama", DiscType.DVD));
		videoCatalog
				.save(new Disc("Hot Shots! Part Deux", "hspd", Money.of(9999.0, EURO), "Action/Comedy/War", DiscType.DVD));
		videoCatalog.save(new Disc("Avatar: The Last Airbender", "tla", Money.of(19.99, EURO), "Animation/Action/Adventure",
				DiscType.DVD));

		videoCatalog.save(new Disc("Secretary", "secretary", Money.of(6.99, EURO), "Political Drama", DiscType.BLURAY));
		videoCatalog.save(new Disc("The Godfather", "tg", Money.of(19.99, EURO), "Crime/Drama", DiscType.BLURAY));
		videoCatalog
				.save(new Disc("No Retreat, No Surrender", "nrns", Money.of(29.99, EURO), "Martial Arts", DiscType.BLURAY));
		videoCatalog
				.save(new Disc("The Princess Bride", "tpb", Money.of(39.99, EURO), "Adventure/Comedy/Family", DiscType.BLURAY));
		videoCatalog.save(new Disc("Top Secret!", "ts", Money.of(39.99, EURO), "Comedy", DiscType.BLURAY));
		videoCatalog
				.save(new Disc("The Iron Giant", "tig", Money.of(34.99, EURO), "Animation/Action/Adventure", DiscType.BLURAY));
		videoCatalog.save(new Disc("Battle Royale", "br", Money.of(19.99, EURO), "Action/Drama/Thriller", DiscType.BLURAY));
		videoCatalog.save(new Disc("Oldboy", "old", Money.of(24.99, EURO), "Action/Drama/Thriller", DiscType.BLURAY));
		videoCatalog.save(new Disc("Bill & Ted's Excellent Adventure", "bt", Money.of(29.99, EURO),
				"Adventure/Comedy/Family", DiscType.BLURAY));
		// Chiggis BlueRay
		videoCatalog.save(new Disc("Banana Joe", "bananaJoe", Money.of(10000000.00, EURO), "Äcktschn/ Komädi", DiscType.BLURAY));

		// CD Kategorie
		videoCatalog.save(new Disc("The Dark Side of the Moon", "darkside", Money.of(14.99, EURO), "Progressive Rock", DiscType.CD));
		videoCatalog.save(new Disc("Abbey Road", "abbeyroad", Money.of(13.49, EURO), "Rock", DiscType.CD));
		videoCatalog.save(new Disc("Thriller", "thriller", Money.of(16.99, EURO), "Pop", DiscType.CD));
		videoCatalog.save(new Disc("Rumours", "rumours", Money.of(12.99, EURO), "Soft Rock", DiscType.CD));
		videoCatalog.save(new Disc("Nevermind", "nevermind", Money.of(14.49, EURO), "Grunge", DiscType.CD));
		videoCatalog.save(new Disc("Hotel California", "hotelcalifornia", Money.of(13.99, EURO), "Rock", DiscType.CD));
		videoCatalog.save(new Disc("Led Zeppelin IV", "lziv", Money.of(15.49, EURO), "Hard Rock", DiscType.CD));
		videoCatalog.save(new Disc("1989", "1989", Money.of(11.99, EURO), "Pop", DiscType.CD));
		videoCatalog.save(new Disc("American Idiot", "americanidiot", Money.of(13.79, EURO), "Punk Rock", DiscType.CD));
		videoCatalog.save(new Disc("Live at Wembley Stadium", "wembley2003", Money.of(17.99, EURO), "Rock", DiscType.DVD));

	}
}
