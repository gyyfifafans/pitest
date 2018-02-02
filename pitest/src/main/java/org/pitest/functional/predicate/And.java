/*
 * Copyright 2010 Henry Coles
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.functional.predicate;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author henry
 *
 */
public class And<A> implements Predicate<A> {

  private final Set<Predicate<A>> ps = new LinkedHashSet<>();

  public And(final Iterable<? extends Predicate<A>> ps) {
    for (final Predicate<A> each : ps) {
      this.ps.add(each);
    }
  }

  @Override
  public Boolean test(final A a) {
    for (final Predicate<A> each : this.ps) {
      if (!each.test(a)) {
        return false;
      }
    }
    return !this.ps.isEmpty();
  }

}