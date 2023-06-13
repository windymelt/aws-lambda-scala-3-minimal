## Minimal AWS Lambda handler using Scala 3 with logging & JSON handling

### Use as JAR

1. `sbt assembly` to generate JAR runnable on AWS Lambda
2. Upload `./target/scala-3.3.0/aws-lambda-scala-3-minimal-assembly-0.1.0-SNAPSHOT.jar` to AWS Lambda
3. Set up lambda function on AWS management console (CAVEAT: Don't forget to specify main entrypoint)

## Use as Custom Container Runtime

1. `sbt assembly` to generate JAR
2. `docker build -t YOUR_CONTAINER_IMAGE_NAME .` to build custom runtime container
3. Push image to ECR
4. Set up lambda function on AWS management console and use the image
