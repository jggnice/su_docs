%%%%%%%%%%%%%%
%Testfun239
format long
count = 1;
x0 = 1;
x1 = 2;
disp('牛顿迭代')
disp(['初值:',num2str(x0)])


while(abs(x1-x0)>1e-8)
    disp(['第' num2str(count) '次:'])
       x0 = x1;
    x1 = fun239_2(x0);
     disp(['结果' num2str(x1)])
  
     count = count + 1;
end