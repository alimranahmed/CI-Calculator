# CI- Calculator

    Version: 2.0.0
    System requirement: Java Virtual Machine(JVM);
    Date of Released: 21st February 2017
    Copyright: 2017, Al- Imran Ahmed

## Screenshot
![CI-Calculator](https://raw.githubusercontent.com/alimranahmed/ci-calculator/master/assets/screenshot_2_0.png)

## Installation 
1. Clone the repo using: `git clone https://github.com/alimranahmed/CI-Calculator.git`
2. Compile & run the java file inside /src.

## Usage
1. To perform any double operand operation, users have to enter one operand then the operation then another operand then the equal button.
	e.g. 1 + 2 =

2. To perform any single operand operation, user have to enter the operand then the operation button.
	e. g. entering  "0 sin"  is as "sin(0)"

3. To calculate percentage, users have to enter operand(for which, percentage will be calculated) then the multiplication button(x) then enter the amount of percent then press the percent button(%).
	e. g. 200 x 5%

4. In the calculator, C => Clear, Del => Delete by one digit, Mod => Reminder of division

## Technical Description
Calculators functionality is defined in the `Engine` class. 
`ActionServer` is handling button click event. 
`ElementContainer` class bind all calculator visual element together. 
`ButtonHolder` create all required buttons those are being used by `ElementContainer`

## Limitation

1. This calculator is not able to evaluate any mathematical expression.
2. Due to, the limitation of value container(e.g. variable) this can't work with very large number(more than 32 bits or 64 bits).
3. Digit limitation is 15 digit.

## Contribution
Contribution to is always welcome. If you want to contribute on this project just create an issue and then make a pull request with your contribution.
