![Banner](https://github.com/Studiomjt/java-end2end-encryption/blob/master/banner.jpg)
# Java Console End to End Encryption
<h4>This project uses symmetric AES with 128bit secret key & asymmetric RSA with 1024bit public & private key to encrypt data</h4>

You can read about E2EE in <a href="https://en.wikipedia.org/wiki/End-to-end_encryption">Wikipedia</a>

<h3>:fire: Example of Project Mechanism </h3>
<h4> Mehdi want to send message to shahram</h4>
&nbsp;&nbsp;&nbsp;&nbsp;1. mehdi write the message<br>
&nbsp;&nbsp;&nbsp;&nbsp;2. message encrypt with AES(128bit) random generated secret key<br>
&nbsp;&nbsp;&nbsp;&nbsp;3. random generated secret key encrypt with RSA(1024) & shahram public key<br>
&nbsp;&nbsp;&nbsp;&nbsp;4. mehdi send encrypted message & encrypted secret key to shahram<br>
&nbsp;&nbsp;&nbsp;&nbsp;5. shahram decrypt the encrypted secret key<br>
&nbsp;&nbsp;&nbsp;&nbsp;6. shahram decrypt the encrypted message with secret key & finally can see the message<br>
<br>
<h4>This project can be used for Android :iphone: & IOS :apple: projects</h4>
<h3> If you like it, please tap the Star(:star:) button at above page</h3>
