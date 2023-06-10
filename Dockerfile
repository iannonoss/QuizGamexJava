FROM node:17.0.1-alpine
WORKDIR /app
COPY myapp/ app
RUN npm install --production
CMD ["node", "src/index.js"]
