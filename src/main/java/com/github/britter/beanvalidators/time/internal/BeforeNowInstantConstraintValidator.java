/*
 * Copyright 2017 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.britter.beanvalidators.time.internal;

import com.github.britter.beanvalidators.internal.NullAcceptingConstraintValidator;
import com.github.britter.beanvalidators.time.BeforeNow;

import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.util.Optional;

public final class BeforeNowInstantConstraintValidator implements NullAcceptingConstraintValidator<BeforeNow, Instant> {

    /**
     * Only for testing!
     */
    static Optional<Instant> suppliedNow = Optional.empty();

    @Override
    public boolean isValidNonNullValue(Instant value, ConstraintValidatorContext context) {
        return value.isBefore(now());
    }

    private Instant now() {
        return suppliedNow.orElse(Instant.now());
    }
}
