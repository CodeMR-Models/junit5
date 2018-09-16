/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Leap Year Specification")
class LeapYearSpecDemo {

	@Nested
	class A_year_is_a_leap_year {

		@Test
		void if_it_is_divisible_by_4_but_not_by_100() {
		}
	}

	@Nested
	class A_year_is_not_supported {

		@Test
		void if_it_is_0() {
		}

		@ParameterizedTest(name = "For example, year {0} is not supported.")
		@ValueSource(ints = { -1, -4 })
		void if_it_is_negative(int year) {
		}
	}
}
