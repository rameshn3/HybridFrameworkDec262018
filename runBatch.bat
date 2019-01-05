set myProjectpath=D:\eclipseworkspaceAug2018\HybridFrWrkMrningBatch630To730AMDec232018
echo %myProjectpath%
cd %myProjectpath%
set classpath=%myProjectpath%\bin;%myProjectpath%\lib\*
java org.testng.TestNG %myProjectpath%\testng.xml 
pause