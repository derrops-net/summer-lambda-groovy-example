# Summer Lambda Groovy Example

Example showing off the Summer Lambda Plugin with 


## Setup
You will need a role for your Lambda:

```bash
aws iam create-role --path "/" --assume-role-policy-document file://AssumeRolePolicyDocument.json --role-name DerropsLambdaRole

export AWS_DERROPS_ROLE="arn:aws:iam::${AWS_ACCOUNT_ID}:role/DerropsLambdaRole"
```

And a bucket to store the code and dependencies:

```bash
aws s3 mb "s3://${AWS_ACCOUNT_ID}-derrops"
export AWS_DERROPS_BUCKET = "${AWS_ACCOUNT_ID}-derrops
```

You will also need to set your region:

```bash
export AWS_REGION="ap-southeast-2"
```

## Deploying Lambda
With the role, bucket and region set, you can now Deploy the function:

```bash
gradle publishFunction
```

This will create the function if it does not exist, which will be named: `${project.name}`, 5 layers will be created each holding dependencies `${project.name}-1..5`, as a function can have up to 5 layers.

## Testing the Lambda
This Lambda handles events in the form of API Gateway, to test the function, it should be invoked using an example of an API Gateway event:


```bash
aws lambda invoke --function-name hello-spring-lambda response.json --payload fileb://event.json
cat response.json
```
