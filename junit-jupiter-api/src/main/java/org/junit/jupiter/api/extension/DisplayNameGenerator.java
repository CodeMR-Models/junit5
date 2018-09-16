/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.api.extension;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;

import java.lang.reflect.Method;

import org.apiguardian.api.API;
import org.junit.platform.commons.util.ClassUtils;

/**
 * {@code DisplayNameGenerator} defines the {@link Extension} API for
 * generating display names programmatically.
 *
 * @since 5.4
 */
@API(status = EXPERIMENTAL, since = "5.4")
public interface DisplayNameGenerator extends Extension {

	default String generateDisplayNameForClass(Class<?> testClass) {
		String name = testClass.getName();
		int index = name.lastIndexOf('.');
		return name.substring(index + 1);
	}

	default String generateDisplayNameForNestedClass(Class<?> nestedClass) {
		return nestedClass.getSimpleName();
	}

	default String generateDisplayNameForMethod(Method testMethod) {
		return String.format("%s(%s)", testMethod.getName(),
			ClassUtils.nullSafeToString(Class::getSimpleName, testMethod.getParameterTypes()));
	}
}
