/*
 * Copyright 2014-2016 the original author or authors.
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

package ian.hu.wechat.sdk.service.media.result;


import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.regex.Pattern;

public final class ResultHelper {
    private static final Pattern HEADER_PATTERN = Pattern.compile("^.*filename=\"([^\"]*)\"");

    private ResultHelper() {
    }

    public static <T extends CompositeResult> T from(Response response, Class<T> clazz) {
        T result;
        try {
            result = clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(String.format("%s need a public constructor without parameter", clazz.getSimpleName()), e);
        }
        MediaType from = result.fromMediaType();
        MediaType ref = response.getMediaType();
        if (from.isWildcardType() || from.getType().equalsIgnoreCase(ref.getType()) && (from.isWildcardSubtype() || from.getSubtype().equalsIgnoreCase(ref.getSubtype()))) {
            response.getHeaders().putSingle(HttpHeaders.CONTENT_TYPE, result.toMediaType());
            return response.readEntity(clazz);
        }

        Object contentDisposition = response.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION);
        if (contentDisposition == null) {
            result.setErrorCode(400);
            result.setErrorMessage("Header Content-Disposition is not found, can't read entity");
            return result;
        }

        response.getHeaders().putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_TYPE);
        try {
            result.setFile(response.readEntity(File.class));
            result.setFileName(HEADER_PATTERN.matcher(contentDisposition.toString()).replaceAll("$1"));
            result.setErrorCode(0);
            result.setErrorMessage("ok");
        } catch (ProcessingException e) {
            result.setErrorCode(400);
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }
}
