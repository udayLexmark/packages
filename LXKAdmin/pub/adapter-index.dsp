
<HTML>
   <TITLE>%value text% - %value $host% - webMethods Integration Server</TITLE>
   <!-- MASTER FRAMESET -->
   <FRAMESET  rows="50,*"  border="0"  framespacing="0"  spacing="0"
   frameborder="0">
   <FRAME  src="top.dsp?adapter=%value -urlencode adapter%&text=%value -urlencode text%%ifvar help%&help=%value help%%endif%"
   marginwidth="0"  marginheight="0"  border="0"  name="topmenu" scrolling="no" noresize>
   <FRAMESET  cols="190,*"  border="0"  framespacing="0"  spacing="0"
   frameborder="0">
   <FRAME  src="adapter-menu.dsp?tabset=%value -urlencode adapter%"  marginwidth="0"
   marginheight="0"  name="menu" scrolling="yes" noresize>
   <FRAME src="%value url%"  marginwidth="0"  marginheight="0"
   name="body">
   </FRAMESET>
   </FRAMESET>
   <!-- END of FRAMESET -->
   <NOFRAMES>
   <BODY>
    <BLOCKQUOTE>
         <H4>
         Your browser does not support frames.  Support for frames is required to use the webMethods Integration Server interface.
         </H4>
       </BLOCKQUOTE>
   </BODY>
   </NOFRAMES>
</HTML>
