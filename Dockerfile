FROM public.ecr.aws/lambda/java:17
COPY target/scala-3.3.0/aws-lambda-scala-3-minimal-assembly-0.1.0-SNAPSHOT.jar ${LAMBDA_TASK_ROOT}/lib/
CMD [ "com.github.windymelt.lambdascala3test.Main::handler" ]
