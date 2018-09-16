/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.engine.descriptor;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.DisplayNameGenerator;

/**
 * Default implementation of the {@link DisplayNameGenerator} API.
 *
 * @since 5.4
 */
class DefaultDisplayNameGenerator implements DisplayNameGenerator {

	@Override
	public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
		if (nestedClass.getSimpleName().contains("_")) {
			return nestedClass.getSimpleName().replace('_', ' ') + "...";
		}
		return DisplayNameGenerator.super.generateDisplayNameForNestedClass(nestedClass);
	}

	@Override
	public String generateDisplayNameForMethod(Method testMethod) {
		if (testMethod.getName().contains("_")) {
			StringBuilder builder = new StringBuilder();
			Class<?> current = testMethod.getDeclaringClass();
			while (current != null) {
				String currentSimpleName = current.getSimpleName();
				current = current.getEnclosingClass();
				if (current == null) {
					break;
				}
				builder.insert(0, ' ');
				builder.insert(0, currentSimpleName);
			}
			builder.append(testMethod.getName());
			builder.append('.');
			return builder.toString().replace('_', ' ');
		}

		return DisplayNameGenerator.super.generateDisplayNameForMethod(testMethod);
	}
}
