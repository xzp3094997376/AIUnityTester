using NUnit.Framework;
using Altom.AltUnityDriver;
using UnityEngine;

public class MyAltUnityTest
{
    public AltUnityDriver altUnityDriver;
    //Before any test it connects with the socket
    [OneTimeSetUp]
    public void SetUp()
    {
        altUnityDriver =new AltUnityDriver();
    }

    //At the end of the test closes the connection with the socket
    [OneTimeTearDown]
    public void TearDown()
    {
        altUnityDriver.Stop();
    }

    [Test]
    public void Test()
    {
	//Here you can write the test
    AltUnityObject altObj= altUnityDriver.FindObject(By.NAME, "UIWithWorldSpace");
    Assert.AreEqual(altObj,null,"//不为空");
    }

}