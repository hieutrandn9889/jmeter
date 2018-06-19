//check if the Parameters is null
def operation = Parameters ? args[0].toLowerCase() : 'null parameters';
 
//check the operator
if (operation != 'sum' && operation != 'multiply') {
 SampleResult.setSuccessful(false);
 SampleResult.setResponseCode("500");
 SampleResult.setResponseMessage("Missing or incorrect the args operation. Expected 'sum' or 'multiply'. But found '" + operation + "'");
 SampleResult.setResponseData("");
 log.info("Missing or incorrect the args operation. Expected 'sum' or 'multiply'. But found '" + operation + "'");
 return true;
}
 
log.info("The operations is: " + operation);
 
//check the list of number
for (i = 1; i < args.length; i++) {
 if(!args[i].isInteger()) {
 SampleResult.setSuccessful(false);
 SampleResult.setResponseCode("500");
 SampleResult.setResponseMessage("There is an incorrect number in the list: " + args[i]);
 SampleResult.setResponseData("");
 log.info("There is an incorrect number in the list: " + args[i]);
 return true;
 }
}
 
//calculate in case of sum
if (operation == 'sum') {
 long sum = 0;
 for (i = 1; i < args.length; i++) {
 sum += args[i].toInteger();
 }
 log.info("sum = " + sum)
}
 
//calculate in case of multiply
if (operation == 'multiply') {
 long multiply = (args.length > 1) ? 1 : 0;
 for (i = 1; i < args.length; i++) {
 multiply *= args[i].toInteger();
 }
 log.info("multiply: " + multiply)
}