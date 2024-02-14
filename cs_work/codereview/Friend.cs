using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace codereview
{
    public class Friend
    {
        private String name;
        public Friend(String name) { this.name = name; }
        public string getName() { return name; }
        
        public override String ToString () {
            //return "friend (name - " + name;
            return $"Friend name = {name}";
        }


    }
}
