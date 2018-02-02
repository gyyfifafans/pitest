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
package org.pitest.functional;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.pitest.functional.predicate.Predicate;

public interface FunctionalIterable<A> extends Iterable<A> {

  void forEach(SideEffect1<A> e);

  <B> List<B> map(Function<A, B> f);

  <B> void mapTo(Function<A, B> f, Collection<? super B> bs);

  <B> List<B> flatMap(Function<A, ? extends Iterable<B>> f);

  List<A> filter(Predicate<A> predicate);

  boolean contains(Predicate<A> predicate);
}
