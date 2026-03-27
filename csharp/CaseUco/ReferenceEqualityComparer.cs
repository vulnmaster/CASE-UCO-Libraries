using System.Collections.Generic;
using System.Runtime.CompilerServices;

namespace CaseUco
{
    internal sealed class ReferenceEqualityComparer : IEqualityComparer<object>
    {
        public new bool Equals(object x, object y)
        {
            return ReferenceEquals(x, y);
        }

        public int GetHashCode(object obj)
        {
            return RuntimeHelpers.GetHashCode(obj);
        }
    }
}
