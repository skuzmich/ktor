/*
 * Copyright 2014-2019 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.http.cio.websocket

import kotlinx.coroutines.*

/**
 * Create [DefaultWebSocketSession] from session.
 */
@OptIn(WebSocketInternalAPI::class)
expect fun DefaultWebSocketSession(
    session: WebSocketSession,
    pingInterval: Long,
    timeoutMillis: Long
): DefaultWebSocketSession

/**
 * Default websocket session with ping-pong and timeout processing and built-in [closeReason] population
 */
expect interface DefaultWebSocketSession : WebSocketSession {
    /**
     * A close reason for this session. It could be `null` if a session is terminated with no close reason
     * (for example due to connection failure).
     */
    val closeReason: Deferred<CloseReason?>
}
