% 大学数学实验2 p.250,255 实验11 例2, 班级成绩比较
% 大学数学实验 p.234-235,238 实验10 例2, 班级成绩比较
XA = [92 88 85 92 95 79 84 87 88 65 93 73 88 87 94 80 ...
69 86 88 78 79 68 88 87 55 93 79 85 90 53 99 81];
XB = [84 83 82 85 82 81 82 90 84 78 75 83 78 85 84 79 ...
85 73 90 77 81 82 82 80 86 83 77 78];

xAm = mean(XA) 
xAm = std(XA) 
xBm = mean(XB) 
xBm = std(XB) 

%[N,Y]=hist(X)	% 频数表
figure(1)
hist(XA,54.5:10:95)	% 直方图 以44.5, 54.5, 64.5...为中点作图
figure(2)
hist(XB,54.5:10:95)	
