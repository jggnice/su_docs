%%%%%%%%%%%%%%
%Testfun239
format long
count = 1;
x0 = 1;
x1 = 2;
disp('ţ�ٵ���')
disp(['��ֵ:',num2str(x0)])


while(abs(x1-x0)>1e-8)
    disp(['��' num2str(count) '��:'])
       x0 = x1;
    x1 = fun239_2(x0);
     disp(['���' num2str(x1)])
  
     count = count + 1;
end