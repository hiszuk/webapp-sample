FROM node:14.7.0

RUN apt-get update

WORKDIR /webapp
COPY ./webapp /webapp

RUN npm install
RUN npm run build

ENV HOST 0.0.0.0

CMD ["npm", "run", "start"]

EXPOSE 3000
