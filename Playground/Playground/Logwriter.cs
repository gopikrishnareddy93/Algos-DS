using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Playground
{
    public class Logwriter
    {
        private static ConcurrentQueue<string> m_LogMessages;
        private static Task m_MessageWriterTask;
        private static CancellationTokenSource m_TokenSource;
        private static CancellationToken m_CancellationToken;
        private static bool m_Started;
        private static bool m_Initialized;
        private static int m_Counter;
        private static string m_FilePath;

        public Logwriter()
        {
            if (m_Initialized)
            {
                return;
            }
            
            m_Initialized = true;
            m_LogMessages = new ConcurrentQueue<string>();
            m_TokenSource?.Dispose();
            m_TokenSource = new CancellationTokenSource();
            m_CancellationToken = m_TokenSource.Token;
            m_Started = true;
            m_Counter = 0;
            m_FilePath = "test.log";
            m_MessageWriterTask = new Task(DoWork, m_CancellationToken, TaskCreationOptions.LongRunning);
        }


        public void Open()
        {
            m_Counter++;
        }

        public void Log(string message)
        {
            m_LogMessages.Enqueue(message);
        }
        
        public void Log(int message)
        {
            m_LogMessages.Enqueue(message.ToString());
        }


        public void Close()
        {
            m_Counter--;

            if (m_Counter == 0)
            {
                m_Initialized = false;
                m_TokenSource.Cancel();
            }
        }


        private void DoWork()
        {
            if (!m_LogMessages.Any())
            {
                return;
            }
            
            while (!m_CancellationToken.IsCancellationRequested)
            {
                WriteToLogFile(false);

                Task.Delay(100, m_CancellationToken);
            }

            WriteToLogFile(true);
        }

        private void WriteToLogFile(bool flushQueue)
        {
            if (!m_LogMessages.Any())
            {
                return;
            }


            if (File.Exists(m_FilePath))
            {

            }

            using (var fh = File.Open(m_FilePath, FileMode.OpenOrCreate, FileAccess.Write, FileShare.None))
            using (var sw = new StreamWriter(fh))
            {
                int i = 0;

                while (flushQueue || i < 10000)
                {
                    if (!m_LogMessages.TryDequeue(out string message))
                    {
                        break;
                    }

                    sw.Write(message);
                    i++;
                }
            }
        }

    }
}
