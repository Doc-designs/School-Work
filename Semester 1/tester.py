import TestDoc;
import unittest;

class unitTest(unittest.TestCase):
    def test1(self):
        self.assertEqual(TestDoc.dict_finder(0), ["Bubble", "Gargle", "Plop", "Dweller"]);
    def test2(self):
        self.assertEqual(TestDoc.dict_finder(2), ["Peeve", "Coundry", "Johnny", "Samantha"]);
    def test3(self):
        self.assertEqual(TestDoc.dict_finder(1), ["Junior, Lecter, Riley, Teron"]);
    def test4(self):
        self.assertEqual(TestDoc.dict_finder(5), ["Butter", "Narval", "Larry", "Soundra"]);
    


if __name__ == "__main__":
    unittest.main(exit=True);