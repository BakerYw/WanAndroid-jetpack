/*
 * Copyright (c) 2021. com.nyw.libbase.launcher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")

package com.nyw.libbase.callbacks

/**
 * @author NieYuWen
 */

/** A callback that takes 0 arguments. */
fun interface Callback0 {
  /** Invokes the callback. */
  operator fun invoke()
}

/** A callback that takes 1 argument. */
fun interface Callback1<in P1> {
  /** Invokes the callback with the specified argument. */
  operator fun invoke(p1: P1)
}

/** A callback that takes 2 arguments. */
fun interface Callback2<in P1, in P2> {
  /** Invokes the callback with the specified arguments. */
  operator fun invoke(p1: P1, p2: P2)
}

/** A callback that takes 3 arguments. */
fun interface Callback3<in P1, in P2, in P3> {
  /** Invokes the callback with the specified arguments. */
  operator fun invoke(p1: P1, p2: P2, p3: P3)
}

/** A callback that takes 4 arguments. */
fun interface Callback4<in P1, in P2, in P3, in P4> {
  /** Invokes the callback with the specified arguments. */
  operator fun invoke(p1: P1, p2: P2, p3: P3, p4: P4)
}

/** A callback that takes 5 arguments. */
fun interface Callback5<in P1, in P2, in P3, in P4, in P5> {
  /** Invokes the callback with the specified arguments. */
  operator fun invoke(p1: P1, p2: P2, p3: P3, p4: P4, p5: P5)
}