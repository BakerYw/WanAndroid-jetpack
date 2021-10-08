/*
 * Copyright (c) 2021. NieYuWen
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

package com.nyw.libbase.launcher

import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import com.nyw.libbase.callbacks.Callback0
import com.nyw.libbase.callbacks.Callback1
import kotlinx.coroutines.flow.flow

/**
 * @author NieYuWen
 */
class RequestPermissionLauncher(private val caller: ActivityResultCaller) :
  BaseActivityResultLauncher<String, Boolean>(caller, RequestPermission()) {

  private val settingsLauncher = AppDetailsSettingsLauncher(caller)

  @JvmOverloads
  fun launch(
    permission: String,
    onGranted: Callback0,
    onDenied: Callback1<AppDetailsSettingsLauncher>,
    onExplainRequest: Callback0? = null
  ) {
    launch(permission) {
      when {
        it -> onGranted()
        caller.shouldShowRequestPermissionRationale(permission) ->
          onExplainRequest?.invoke() ?: onDenied(settingsLauncher)
        else -> onDenied(settingsLauncher)
      }
    }
  }

  fun launchForFlow(
    permission: String,
    onDenied: Callback1<AppDetailsSettingsLauncher>,
    onExplainRequest: Callback0? = null
  ) = flow {
    when {
      launchForResult(permission) -> emit(Unit)
      caller.shouldShowRequestPermissionRationale(permission) ->
        onExplainRequest?.invoke() ?: onDenied(settingsLauncher)
      else -> onDenied(settingsLauncher)
    }
  }
}