function rcoplot(r, rint)
%RCOPLOT  Residual case order plot.
%   RCOPLOT(R, RINT) case order errorbar plot of confidence intervals on 
%   residuals from a regression. R and RINT are outputs of REGRESS. 
%
%   See also REGRESS.

%   B.A. Jones 1-29-96
%   Copyright 1993-2002 The MathWorks, Inc. 
%   $Revision: 1.10 $  $Date: 2002/01/17 21:31:52 $

n = length(r);
cases= (1:n)';
maxr = max(rint');
minr = min(rint');

flag=find(minr > 0 | maxr < 0);
if any(flag)
   rf = r(flag);
   rif = rint(flag,:);
   cf = cases(flag);
   X=[cf cf]';
   XX=[cf-0.2 cf+0.2]';
   YY1=[rif(:,1) rif(:,1)]';
   YY2=[rif(:,2) rif(:,2)]';
   Y = rif';

   %plot(X,Y,'r-',XX,YY1,'r-',XX,YY2,'r-',cf,rf,'ro',[0 (n+1)],[0 0],'-w');
   plot(X,Y,'r-',XX,YY1,'r-',XX,YY2,'r-',cf,rf,'ro',[0 (n+1)],[0 0],'-k');
   hold on

   cases(flag) = [];
   r(flag) = [];
   rint(flag,:) = [];
end

if ~isempty(cases)
   X=[cases cases]';
   XX=[cases-0.2 cases+0.2]';
   YY1=[rint(:,1) rint(:,1)]';
   YY2=[rint(:,2) rint(:,2)]';
   Y = rint';
   %plot(X,Y,'g-',XX,YY1,'g-',XX,YY2,'g-',cases,r,'go',[0 (n+1)],[0 0],'-w');
   plot(X,Y,'b-',XX,YY1,'b-',XX,YY2,'b-',cases,r,'bo',[0 (n+1)],[0 0],'-k');
   hold off
end

maxr = max(0,maxr);
minr = min(0,minr);
axis([0.5 n+0.5 1.03*min(minr) 1.03*max(maxr)]);
% set(gca,'Color','k');
set(gcf,'color','k')    %WZY
title('Residual Case Order Plot');
ylabel('Residuals');
xlabel('Case Number');

