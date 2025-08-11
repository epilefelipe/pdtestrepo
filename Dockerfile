FROM eclipse-temurin:21-jdk-alpine AS backend-build

RUN apk add --no-cache git bash

WORKDIR /pdtestrepo

RUN git clone --branch main https://github.com/epilefelipe/pdtestrepo .

WORKDIR /pdtestrepo/pruebaback

RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

RUN ls -l build/libs/

FROM node:18-alpine AS microfrontend1-build

RUN apk add --no-cache git

WORKDIR /pdtestrepo

RUN git clone --branch main https://github.com/epilefelipe/pdtestrepo .

WORKDIR /pdtestrepo/host_main

RUN npm install

RUN npm run build

FROM node:18-alpine AS microfrontend2-build

RUN apk add --no-cache git

WORKDIR /pdtestrepo

RUN git clone --branch main https://github.com/epilefelipe/pdtestrepo .

WORKDIR /pdtestrepo/remote_UM

RUN npm install

RUN npm run build

FROM openjdk:21-jdk-alpine AS backend-runtime

WORKDIR /app

COPY --from=backend-build /pdtestrepo/pruebaback/build/libs/test.jar ./test.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "test.jar"]

# ===== Imagen nginx para microfrontend1 =====
FROM nginx:stable-alpine AS microfrontend1-runtime

COPY --from=microfrontend1-build /pdtestrepo/host_main/build /usr/share/nginx/html

EXPOSE 3001

CMD ["nginx", "-g", "daemon off;"]

# ===== Imagen nginx para microfrontend2 =====
FROM nginx:stable-alpine AS microfrontend2-runtime

COPY --from=microfrontend2-build /pdtestrepo/remote_UM/build /usr/share/nginx/html

EXPOSE 3002

CMD ["nginx", "-g", "daemon off;"]
